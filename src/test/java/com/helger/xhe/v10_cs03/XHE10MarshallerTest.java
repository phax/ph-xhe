/**
 * Copyright (C) 2019-2021 Philip Helger (www.helger.com)
 * philip[at]helger[dot]com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.helger.xhe.v10_cs03;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.UUID;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.helger.commons.datetime.PDTFactory;
import com.helger.commons.io.file.FileSystemIterator;
import com.helger.commons.mime.CMimeType;
import com.helger.xhe.v10_cs03.cac.XHE10HeaderType;
import com.helger.xhe.v10_cs03.cac.XHE10PartyIdentificationType;
import com.helger.xhe.v10_cs03.cac.XHE10PartyType;
import com.helger.xhe.v10_cs03.cac.XHE10PayloadContentType;
import com.helger.xhe.v10_cs03.cac.XHE10PayloadType;
import com.helger.xhe.v10_cs03.cac.XHE10PayloadsType;

/**
 * Test class for class {@link XHE10Marshaller}.
 *
 * @author Philip Helger
 */
public final class XHE10MarshallerTest
{
  private static final Logger LOGGER = LoggerFactory.getLogger (XHE10MarshallerTest.class);

  @Test
  public void testReadGood ()
  {
    LOGGER.info ("Reading good XHE files");
    final XHE10Marshaller aMarshaller = new XHE10Marshaller ();
    for (final File aFile : new FileSystemIterator ("src/test/resources/examples/xhe10-cs03/good"))
      if (aFile.isFile ())
      {
        LOGGER.info ("  " + aFile.getName ());
        assertNotNull (aFile.getAbsolutePath (), aMarshaller.read (aFile));
      }
  }

  @Test
  public void testReadBad ()
  {
    LOGGER.info ("Reading bad XHE files");
    final XHE10Marshaller aMarshaller = new XHE10Marshaller ();
    for (final File aFile : new FileSystemIterator ("src/test/resources/examples/xhe10-cs03/bad"))
      if (aFile.isFile ())
      {
        LOGGER.info ("  " + aFile.getName ());
        assertNull (aFile.getAbsolutePath (), aMarshaller.read (aFile));
      }
  }

  @Test
  public void testCreateFromScratch ()
  {
    final XHE10Marshaller m = new XHE10Marshaller ();
    final XHE10XHEType aXHE = new XHE10XHEType ();
    aXHE.setXHEVersionID ("1.0");
    {
      final XHE10HeaderType aHeader = new XHE10HeaderType ();
      aHeader.setID (UUID.randomUUID ().toString ());
      aHeader.setCreationDateTime (PDTFactory.getCurrentOffsetDateTime ());
      for (int i = 0; i < 3; ++i)
      {
        final XHE10PartyType aToParty = new XHE10PartyType ();
        final XHE10PartyIdentificationType aID = new XHE10PartyIdentificationType ();
        aID.setID ("id-" + i + "-to");
        aToParty.addPartyIdentification (aID);
        aHeader.addToParty (aToParty);
      }
      aXHE.setHeader (aHeader);
    }
    {
      final XHE10PayloadsType aPayloads = new XHE10PayloadsType ();
      for (int i = 0; i < 3; ++i)
      {
        final XHE10PayloadType aPayload = new XHE10PayloadType ();
        aPayload.setContentTypeCode (CMimeType.TEXT_PLAIN.getAsString ());
        aPayload.setInstanceEncryptionIndicator (false);
        final XHE10PayloadContentType aContent = new XHE10PayloadContentType ();
        aContent.addContent ("Test XHE " + i);
        aPayload.setPayloadContent (aContent);
        aPayloads.addPayload (aPayload);
      }
      aXHE.setPayloads (aPayloads);
    }
    assertTrue (m.write (aXHE, new File ("target/dummy.xml")).isSuccess ());
  }
}

/**
 * Copyright (C) 2019-2020 Philip Helger (www.helger.com)
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
package com.helger.xhe.v10_cs02;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import javax.xml.validation.Schema;

import org.junit.Test;

import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.io.resource.ClassPathResource;
import com.helger.xml.schema.XMLSchemaCache;

/**
 * Test class for class {@link CXHE10}.
 *
 * @author Philip Helger
 */
public final class CXHE10Test
{
  @Test
  public void testBasic ()
  {
    assertNotNull (CXHE10.getXSDResourceUnqualifiedDataTypes ());
    assertTrue (CXHE10.getXSDResourceUnqualifiedDataTypes ().exists ());

    assertNotNull (CXHE10.getXSDResourceQualifiedDataTypes ());
    assertTrue (CXHE10.getXSDResourceQualifiedDataTypes ().exists ());

    assertNotNull (CXHE10.getXSDResourceBasicComponents ());
    assertTrue (CXHE10.getXSDResourceBasicComponents ().exists ());

    assertNotNull (CXHE10.getXSDResourceExtensionContentDataType ());
    assertTrue (CXHE10.getXSDResourceExtensionContentDataType ().exists ());

    assertNotNull (CXHE10.getXSDResourceExtensionComponents ());
    assertTrue (CXHE10.getXSDResourceExtensionComponents ().exists ());

    assertNotNull (CXHE10.getXSDResourcePayloadContentDataType ());
    assertTrue (CXHE10.getXSDResourcePayloadContentDataType ().exists ());

    assertNotNull (CXHE10.getXSDResourceAggregateComponents ());
    assertTrue (CXHE10.getXSDResourceAggregateComponents ().exists ());

    assertNotNull (CXHE10.getXSDXHE10 ());
    assertTrue (CXHE10.getXSDXHE10 ().exists ());
    assertEquals (CXHE10.getXSDXHE10 (), CXHE10.getXSDXHE10 ());
    assertNotSame (CXHE10.getXSDXHE10 (), CXHE10.getXSDXHE10 ());
  }

  @Test
  public void testSchemaCreation1 ()
  {
    final ICommonsList <ClassPathResource> aList = CXHE10.getAllXSDIncludes ();
    aList.add (CXHE10.getXSDXHE10 ());

    final Schema aSchema = XMLSchemaCache.getInstance ().getFromCache (aList);
    assertNotNull (aSchema);
  }

  @Test
  public void testSchemaCreation2 ()
  {
    final ICommonsList <ClassPathResource> aList = CXHE10.getAllXSDXHE10 ();

    final Schema aSchema = XMLSchemaCache.getInstance ().getFromCache (aList);
    assertNotNull (aSchema);
  }
}

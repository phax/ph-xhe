/*
 * Copyright (C) 2019-2023 Philip Helger (www.helger.com)
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
package com.helger.xhe.v10;

import javax.annotation.concurrent.NotThreadSafe;

import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.io.resource.ClassPathResource;
import com.helger.jaxb.GenericJAXBMarshaller;

/**
 * This is the reader and writer for XHE 1.0 CS03 documents. This class may be
 * derived to override protected methods from {@link GenericJAXBMarshaller}.
 *
 * @author Philip Helger
 */
@NotThreadSafe
public class XHE10Marshaller extends GenericJAXBMarshaller <XHE10XHEType>
{
  private static final ICommonsList <ClassPathResource> XSDS = CXHE10.getAllXSDXHE10 ();

  public XHE10Marshaller ()
  {
    this (true);
  }

  public XHE10Marshaller (final boolean bValidationEnabled)
  {
    super (XHE10XHEType.class, bValidationEnabled ? XSDS : null, o -> new ObjectFactory ().createXHE (o));

    setNamespaceContext (XHE10NamespaceContext.getInstance ());
  }
}

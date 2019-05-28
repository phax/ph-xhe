/**
 * Copyright (C) 2019 Philip Helger (www.helger.com)
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
package com.helger.xhe;

import javax.annotation.concurrent.NotThreadSafe;

import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.io.resource.ClassPathResource;
import com.helger.jaxb.GenericJAXBMarshaller;
import com.helger.xhe.v10.ObjectFactory;
import com.helger.xhe.v10.XHE10XHEType;
import com.helger.xml.namespace.MapBasedNamespaceContext;
import com.helger.xsds.ccts.cct.schemamodule.CCCTS;
import com.helger.xsds.xades132.CXAdES132;
import com.helger.xsds.xades141.CXAdES141;
import com.helger.xsds.xmldsig.CXMLDSig;

/**
 * This is the reader and writer for XHE 1.0 documents. This class may be
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

    final MapBasedNamespaceContext aNSContext = new MapBasedNamespaceContext ();
    aNSContext.addMapping (CCCTS.DEFAULT_PREFIX, CCCTS.NAMESPACE_URI);
    aNSContext.addMapping (CXMLDSig.DEFAULT_PREFIX, CXMLDSig.NAMESPACE_URI);
    aNSContext.addMapping (CXAdES132.DEFAULT_PREFIX, CXAdES132.NAMESPACE_URI);
    aNSContext.addMapping (CXAdES141.DEFAULT_PREFIX, CXAdES141.NAMESPACE_URI);
    aNSContext.addMapping (CXHE10.DEFAULT_PREFIX_UNQUALIFIED_DATA_TYPES, CXHE10.NAMESPACE_URI_UNQUALIFIED_DATA_TYPES);
    aNSContext.addMapping (CXHE10.DEFAULT_PREFIX_QUALIFIED_DATA_TYPES, CXHE10.NAMESPACE_URI_QUALIFIED_DATA_TYPES);
    aNSContext.addMapping (CXHE10.DEFAULT_PREFIX_BASIC_COMPONENTS, CXHE10.NAMESPACE_URI_BASIC_COMPONENTS);
    aNSContext.addMapping (CXHE10.DEFAULT_PREFIX_AGGREGATE_COMPONENTS, CXHE10.NAMESPACE_URI_AGGREGATE_COMPONENTS);
    aNSContext.addMapping (CXHE10.DEFAULT_PREFIX_EXTENSION_COMPONENTS, CXHE10.NAMESPACE_URI_EXTENSION_COMPONENTS);
    aNSContext.addMapping (CXHE10.DEFAULT_PREFIX_SERVICE_GROUP, CXHE10.NAMESPACE_URI_SERVICE_GROUP);
    setNamespaceContext (aNSContext);
  }
}

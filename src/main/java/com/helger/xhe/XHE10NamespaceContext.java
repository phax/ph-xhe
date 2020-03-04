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
package com.helger.xhe;

import javax.annotation.Nonnull;

import com.helger.commons.annotation.Singleton;
import com.helger.xml.namespace.MapBasedNamespaceContext;
import com.helger.xsds.ccts.cct.schemamodule.CCCTS;
import com.helger.xsds.xades132.CXAdES132;
import com.helger.xsds.xades141.CXAdES141;
import com.helger.xsds.xmldsig.CXMLDSig;

/**
 * The namespace context to be used as the namespace prefix mapper.
 *
 * @author Philip Helger
 * @since 1.0.1
 */
@Singleton
public class XHE10NamespaceContext extends MapBasedNamespaceContext
{
  private static final class SingletonHolder
  {
    static final XHE10NamespaceContext s_aInstance = new XHE10NamespaceContext ();
  }

  protected XHE10NamespaceContext ()
  {
    addMapping (CCCTS.DEFAULT_PREFIX, CCCTS.NAMESPACE_URI);
    addMapping (CXMLDSig.DEFAULT_PREFIX, CXMLDSig.NAMESPACE_URI);
    addMapping (CXAdES132.DEFAULT_PREFIX, CXAdES132.NAMESPACE_URI);
    addMapping (CXAdES141.DEFAULT_PREFIX, CXAdES141.NAMESPACE_URI);
    addMapping (CXHE10.DEFAULT_PREFIX_UNQUALIFIED_DATA_TYPES, CXHE10.NAMESPACE_URI_UNQUALIFIED_DATA_TYPES);
    addMapping (CXHE10.DEFAULT_PREFIX_QUALIFIED_DATA_TYPES, CXHE10.NAMESPACE_URI_QUALIFIED_DATA_TYPES);
    addMapping (CXHE10.DEFAULT_PREFIX_BASIC_COMPONENTS, CXHE10.NAMESPACE_URI_BASIC_COMPONENTS);
    addMapping (CXHE10.DEFAULT_PREFIX_AGGREGATE_COMPONENTS, CXHE10.NAMESPACE_URI_AGGREGATE_COMPONENTS);
    addMapping (CXHE10.DEFAULT_PREFIX_EXTENSION_COMPONENTS, CXHE10.NAMESPACE_URI_EXTENSION_COMPONENTS);
    addMapping (CXHE10.DEFAULT_PREFIX_SERVICE_GROUP, CXHE10.NAMESPACE_URI_SERVICE_GROUP);
  }

  @Nonnull
  public static XHE10NamespaceContext getInstance ()
  {
    return SingletonHolder.s_aInstance;
  }
}

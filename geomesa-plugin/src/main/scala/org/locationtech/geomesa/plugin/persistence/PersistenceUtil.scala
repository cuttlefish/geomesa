/***********************************************************************
* Copyright (c) 2013-2015 Commonwealth Computer Research, Inc.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Apache License, Version 2.0 which
* accompanies this distribution and is available at
* http://www.opensource.org/licenses/apache2.0.php.
*************************************************************************/

package org.locationtech.geomesa.plugin.persistence

import java.io.File

import org.locationtech.geomesa.utils.cache.FilePersistence
import org.geoserver.config.GeoServerDataDirectory

object PersistenceUtil {
  var dataDir:Option[GeoServerDataDirectory] = None
  lazy val pu = new FilePersistence(dataDir.get.findOrCreateDir("geomesa-config"), "geomesa-config.properties")

  def read = pu.read _
  def persistAll = pu.persistAll _
  def setDataDir(dd: GeoServerDataDirectory) = { dataDir = Some(dd) }
  def getInstance() = this // used by Spring
}

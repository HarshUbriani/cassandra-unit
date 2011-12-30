package org.cassandraunit;

import java.io.IOException;

import org.apache.cassandra.config.ConfigurationException;
import org.apache.thrift.transport.TTransportException;
import org.cassandraunit.dataset.xml.ClassPathXmlDataSet;
import org.cassandraunit.exception.CassandraUnitException;
import org.cassandraunit.utils.EmbeddedCassandraServerHelper;
import org.junit.Test;

/**
 * 
 * @author Jeremy Sevellec
 * 
 */
public class DataLoaderWithParseHexBytesProblemTest {

	@Test(expected = CassandraUnitException.class)
	public void shouldNotGetLoadData() throws TTransportException, IOException, InterruptedException,
			ConfigurationException {
		EmbeddedCassandraServerHelper.startEmbeddedCassandra();
		DataLoader dataLoader = new DataLoader(CassandraUnit.clusterName, CassandraUnit.host);
		dataLoader.load(new ClassPathXmlDataSet("xml/datasetWithBadBytesKey.xml"));
	}
}

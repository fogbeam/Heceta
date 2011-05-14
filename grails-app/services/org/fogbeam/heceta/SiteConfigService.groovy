package org.fogbeam.heceta

class SiteConfigService 
{

	public String getSiteConfigEntry( final String name )
	{
		SiteConfigEntry entry = SiteConfigEntry.findByName( name );
		return entry.value;
	}
}
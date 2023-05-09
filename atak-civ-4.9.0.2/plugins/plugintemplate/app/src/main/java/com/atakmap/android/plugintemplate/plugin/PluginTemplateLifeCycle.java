package com.atakmap.android.plugintemplate.plugin;

// ----- Android API import ----- //

// ----- Local API import ----- //

// ----- ATAK API import ----- //
import com.atak.plugins.impl.AbstractPlugin;
import com.atak.plugins.impl.PluginContextProvider;
import com.atakmap.android.maps.MapComponent;
import com.atakmap.android.plugintemplate.PluginTemplateMapComponent;

import gov.tak.api.plugin.IServiceController;

public class PluginTemplateLifeCycle extends AbstractPlugin
{
    /** ************************* CONSTRUCTOR ************************* **/
    public PluginTemplateLifeCycle (IServiceController isc)
    {
        super(isc, new PluginTemplatePluginTool(((PluginContextProvider) isc.getService(PluginContextProvider.class)).getPluginContext()),
                        (MapComponent) new PluginTemplateMapComponent());
    }
}

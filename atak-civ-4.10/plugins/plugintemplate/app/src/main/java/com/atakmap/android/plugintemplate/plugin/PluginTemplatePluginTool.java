package com.atakmap.android.plugintemplate.plugin;

// ----- Android API import ----- //;
import android.content.Context;

// ----- ATAK API import ----- //
import com.atak.plugins.impl.AbstractPluginTool;

public class PluginTemplatePluginTool extends AbstractPluginTool
{
    /** ************************* CONSTRUCTOR ************************* **/
    public PluginTemplatePluginTool (final Context context)
    {
        super(context, context.getString(R.string.app_name), context.getString(R.string.app_name),
                context.getResources().getDrawable(R.drawable.ic_launcher),
                "com.atakmap.android.plugintemplate.SHOW_PLUGIN");
        PluginTemplateNativeLoader.init(context);
    }
}

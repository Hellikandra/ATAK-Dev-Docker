package com.atakmap.android.plugintemplate;

// ----- Android API import ----- //
import android.content.Context;
import android.content.Intent;

// ----- Local App import ----- //
import com.atakmap.android.ipc.AtakBroadcast.DocumentedIntentFilter;
import com.atakmap.android.plugintemplate.plugin.R;

// ----- ATAK API import ----- //
import com.atakmap.coremap.log.Log;
import com.atakmap.android.dropdown.DropDownMapComponent;
import com.atakmap.android.maps.MapView;


public class PluginTemplateMapComponent extends DropDownMapComponent
{
    private static final String TAG = "PluginTemplateMapComponent";
    private Context pluginContext;
    private PluginTemplateDropDownReceiver ddr;

    public PluginTemplateMapComponent() {
        super();
    }


    public void onCreate (final Context context, Intent intent, final MapView view)
    {
        context.setTheme(R.style.ATAKPluginTheme);
        super.onCreate(context, intent, view);
        pluginContext = context;

        ddr = new PluginTemplateDropDownReceiver(view, context);

        Log.d(TAG, "registering the plugin filter");
        DocumentedIntentFilter ddFilter = new DocumentedIntentFilter();
        ddFilter.addAction(PluginTemplateDropDownReceiver.SHOW_PLUGIN);
        registerDropDownReceiver(ddr, ddFilter);
    }

    @Override
    protected void onDestroyImpl (Context context, MapView view)
    {
        super.onDestroyImpl(context, view);
    }
}

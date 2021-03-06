package chao.android.tools.service_pools.fragments;

import android.view.View;

import chao.android.tools.service_pools.R;
import chao.android.tools.service_pools.event.MyEvent;
import chao.app.ami.Ami;
import chao.app.ami.UI;
import chao.app.ami.annotations.LayoutID;
import chao.app.ami.base.AMISupportFragment;
import chao.java.tools.servicepool.ServicePool;
import chao.java.tools.servicepool.annotation.Event;

/**
 * @author luqin
 * @since 2019-08-27
 */
@LayoutID(R.layout.main)
public class EventFragment extends AMISupportFragment implements MyEvent {

    @Event
    private MyEvent myEvent;


    public EventFragment() {
    }

    @Override
    public void setupView(View layout) {
        myEvent.postEvent();

        layout.findViewById(R.id.btn).setOnClickListener(v->{
            UI.show(getActivity(), EventFragment.class);
        });
    }

    @Override
    public void postEvent() {
        System.out.println("post event in EventFragment.");
    }


    public class InnerEvent implements MyEvent {

        @Override
        public void postEvent() {
            System.out.println("post event in EventFragment inner.");
        }
    }
}

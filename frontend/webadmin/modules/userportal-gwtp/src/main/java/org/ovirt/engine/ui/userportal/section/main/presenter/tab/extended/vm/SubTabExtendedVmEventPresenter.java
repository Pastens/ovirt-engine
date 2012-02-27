package org.ovirt.engine.ui.userportal.section.main.presenter.tab.extended.vm;

import org.ovirt.engine.ui.common.presenter.AbstractSubTabPresenter;
import org.ovirt.engine.ui.uicommonweb.models.userportal.UserPortalItemModel;
import org.ovirt.engine.ui.uicommonweb.models.userportal.UserPortalListModel;
import org.ovirt.engine.ui.uicommonweb.models.vms.VmEventListModel;
import org.ovirt.engine.ui.userportal.gin.ClientGinjector;
import org.ovirt.engine.ui.userportal.place.ApplicationPlaces;
import org.ovirt.engine.ui.userportal.section.main.presenter.tab.extended.ExtendedVirtualMachineSelectionChangeEvent;
import org.ovirt.engine.ui.userportal.uicommon.model.vm.VmEventListModelProvider;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.TabData;
import com.gwtplatform.mvp.client.TabDataBasic;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.ProxyEvent;
import com.gwtplatform.mvp.client.annotations.TabInfo;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.gwtplatform.mvp.client.proxy.TabContentProxyPlace;

public class SubTabExtendedVmEventPresenter
        extends AbstractSubTabPresenter<UserPortalItemModel, UserPortalListModel, VmEventListModel, SubTabExtendedVmEventPresenter.ViewDef, SubTabExtendedVmEventPresenter.ProxyDef> {

    @ProxyCodeSplit
    @NameToken(ApplicationPlaces.extendedVirtualMachineEventSubTabPlace)
    public interface ProxyDef extends TabContentProxyPlace<SubTabExtendedVmEventPresenter> {
    }

    public interface ViewDef extends AbstractSubTabPresenter.ViewDef<UserPortalItemModel> {
    }

    @TabInfo(container = ExtendedVmSubTabPanelPresenter.class)
    static TabData getTabData(ClientGinjector ginjector) {
        return new TabDataBasic(ginjector.getApplicationConstants().extendedVirtualMachineEventSubTabLabel(),
                5);
    }

    @Inject
    public SubTabExtendedVmEventPresenter(EventBus eventBus, ViewDef view, ProxyDef proxy,
            PlaceManager placeManager, VmEventListModelProvider modelProvider) {
        super(eventBus, view, proxy, placeManager, modelProvider);
    }

    @Override
    protected void revealInParent() {
        RevealContentEvent.fire(this, ExtendedVmSubTabPanelPresenter.TYPE_SetTabContent, this);
    }

    @Override
    protected PlaceRequest getMainTabRequest() {
        return new PlaceRequest(ApplicationPlaces.extendedVirtualMachineSideTabPlace);
    }

    @ProxyEvent
    public void onExtendedVirtualMachineSelectionChange(ExtendedVirtualMachineSelectionChangeEvent event) {
        updateMainTabSelection(event.getSelectedItems());
    }

}

package org.smartregister.family.contract;

import android.util.Pair;

import org.apache.commons.lang3.tuple.Triple;
import org.json.JSONObject;
import org.smartregister.clientandeventmodel.Client;
import org.smartregister.clientandeventmodel.Event;
import org.smartregister.view.contract.BaseRegisterContract;

import java.util.List;

/**
 * Created by keyamn on 12/11/2018.
 */
public interface FamilyRegisterContract {

    interface View extends BaseRegisterContract.View {

    }

    interface Presenter extends BaseRegisterContract.Presenter {

        void saveLanguage(String language);

        void startForm(String formName, String entityId, String metadata, String currentLocationId) throws Exception;

        void saveForm(String jsonString, boolean isEditMode);

        void closeFamilyRecord(String jsonString);

    }

    interface Model {

        void registerViewConfigurations(List<String> viewIdentifiers);

        void unregisterViewConfiguration(List<String> viewIdentifiers);

        void saveLanguage(String language);

        String getLocationId(String locationName);

        Pair<Client, Event> processRegistration(String jsonString);

        JSONObject getFormAsJson(String formName, String entityId,
                                 String currentLocationId) throws Exception;

        String getInitials();

    }

    interface Interactor {

        void onDestroy(boolean isChangingConfiguration);

        void getNextUniqueId(Triple<String, String, String> triple, FamilyRegisterContract.InteractorCallBack callBack);

        void saveRegistration(final Pair<Client, Event> pair, final String jsonString, final boolean isEditMode, final FamilyRegisterContract.InteractorCallBack callBack);

        void removeFamilyFromRegister(String closeFormJsonString, String providerId);

    }

    interface InteractorCallBack {

        void onUniqueIdFetched(Triple<String, String, String> triple, String entityId);

        void onNoUniqueId();

        void onRegistrationSaved(boolean isEdit);

    }
}

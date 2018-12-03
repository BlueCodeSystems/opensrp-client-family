package org.smartregister.family.sample.presenter;

import org.smartregister.family.contract.FamilyProfileMemberContract;
import org.smartregister.family.contract.FamilyRegisterFragmentContract;
import org.smartregister.family.presenter.BaseFamilyProfileMemberPresenter;

public class FamilyProfileMemberPresenter extends BaseFamilyProfileMemberPresenter {

    public FamilyProfileMemberPresenter(FamilyProfileMemberContract.View view, FamilyRegisterFragmentContract.Model model, String viewConfigurationIdentifier, String familyBaseEntityId) {
        super(view, model, viewConfigurationIdentifier, familyBaseEntityId);
    }
}

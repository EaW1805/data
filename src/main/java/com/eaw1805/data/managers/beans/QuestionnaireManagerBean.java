package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.Questionnaire;
import com.eaw1805.data.model.User;

import java.util.List;

/**
 * Created by karavias on 2/26/14.
 */
public interface QuestionnaireManagerBean extends EntityBean {

    /**
     * get the Questionnaire from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    Questionnaire getByID(int entityID);


    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the Questionnaire tha we want to add.
     */
    void add(final Questionnaire value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the Questionnaire tha we want to update.
     */
    void update(final Questionnaire value);

    /**
     * Delete the input Questionnaire from the database.
     *
     * @param entity the Questionnaire tha we want to delete
     */
    void delete(Questionnaire entity);

    /**
     * Listing all the Questionnaires from the database.
     *
     * @return a list of all the Questionnaires that exist inside the table Avatar.
     */
    List<Questionnaire> list();

    /**
     * Listing all the Questionnaires from the database.
     *
     * @return a list of all the Questionnaires that exist inside the table Avatar.
     */
    List<Questionnaire> list(final User user);

}

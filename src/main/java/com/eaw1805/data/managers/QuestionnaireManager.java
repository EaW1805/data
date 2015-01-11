package com.eaw1805.data.managers;

import com.eaw1805.data.managers.beans.QuestionnaireManagerBean;
import com.eaw1805.data.model.Questionnaire;
import com.eaw1805.data.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Handles Questionnair objects.
 */
public class QuestionnaireManager extends AbstractManager<Questionnaire>
        implements QuestionnaireManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static QuestionnaireManagerBean ourInstance = null;

    /**
     * Private constructor suppresses generation of a (public)
     * default constructor.
     */
    public QuestionnaireManager() {
        // Does nothing
        super();
    }


    /**
     * ReportManager is loaded on the first execution of
     * ReportManager.getInstance() or the first access to
     * ReportManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static QuestionnaireManagerBean getInstance() {
        synchronized (QuestionnaireManager.class) {
            if (ourInstance == null) {
                ourInstance = new QuestionnaireManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final QuestionnaireManagerBean thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the Questionnaire from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    public Questionnaire getByID(final int entityID) {
        return super.getByID(new Questionnaire(), entityID);
    }


    /**
     * Delete the input Questionnaire from the database.
     *
     * @param entity the Questionnaire tha we want to delete
     */
    public void delete(final Questionnaire entity) {
        super.delete(entity, entity.getQuestionnaireId());
    }

    /**
     * Listing all the Questionnaires from the database.
     *
     * @return a list of all the Questionnaires that exist inside the table Avatar.
     */
    public List<Questionnaire> list() {
        return super.list(new Questionnaire());
    }

    /**
     * Listing all the Questionnaires from the database.
     *
     * @param user the user responding to the questionnaire.
     * @return a list of all the Questionnaires that exist inside the table Avatar.
     */
    public List<Questionnaire> list(final User user) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Questionnaire.class);
        criteria.add(Restrictions.eq("user", user));
        return criteria.list();
    }

}

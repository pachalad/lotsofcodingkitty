package ca.ualberta.cs.cmput301t03app.interfaces;

import java.util.ArrayList;

import ca.ualberta.cs.cmput301t03app.models.Question;

/**
 * An interface for DataManagers. All DataManagers should be able to save and
 * load the whole Question list.
 * 
 */
public interface IDataManager
{

	public void saveToQuestionBank(ArrayList<Question> list);

	public ArrayList<Question> loadQuestions();
}
import java.util.Date;

import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.cmput301t03app.models.Answer;
import ca.ualberta.cs.cmput301t03app.models.Comment;
import ca.ualberta.cs.cmput301t03app.models.Question;
import ca.ualberta.cs.cmput301t03app.views.MainActivity;

/** 
 * This test suite is used to test the functionality of the Question model
 * @author Eric
 */
public class QuestionModelTest extends ActivityInstrumentationTestCase2<MainActivity> {

	public QuestionModelTest() {
		super(MainActivity.class);
	}
	
	//  Checks if all the attributes get set correctly by the constructor through use of retrieval methods
	public void testQuestionConstructor() {
		Question q1 = new Question("a subject", "a body", "a author");
		Date date = new Date();
		assertEquals("Subject is not 'a subject'", "a subject", q1.getSubject());
		assertEquals("Body is not 'a body'", "a body", q1.getBody());
		assertEquals("author is not 'a author'", "a author", q1.getAuthor());
		assertEquals("Rating is not 0", 0, q1.getRating());
		assertEquals("Date is not set correctly",date, q1.getDate());
	}
	
	// Checks if incrementing the rating works
	public void testIncreaseQuestionScore() {
		Question q1 = new Question("a subject", "a body", "a author");
		assertEquals("Rating is 0", 0, q1.getRating());
		q1.upRating();
		assertEquals("Rating is 1", 1, q1.getRating());
	}
	
	// Checks if an answer can be added by seeing if the object created is the same object in the answer list of the question
	// Also checks to see if two answers with the same attributes are added as separate objects.
	public void testAddAnswer() {
		Question q1 = new Question("a subject", "a body", "a author");
		Answer a1 = new Answer("a body", "a author","1");
		q1.addAnswer(a1);
		assertSame("answer object is not the same", a1, q1.getAnswers().get(0));
		
		Answer a2 = new Answer("a body", "a author","2");
		q1.addAnswer(a2);
		assertNotSame("a1 is a2", a1, a2); // Checks to ensure a1 is not a2
		assertNotSame("a1 is a2", q1.getAnswers().get(0), q1.getAnswers().get(1)); // Now checks to ensure this is also the case for the
																					   // answers added.
		
		q1.addAnswer(a1);
		assertSame("index 1 and 2 dont have the same answer object", q1.getAnswers().get(0), q1.getAnswers().get(2));
	}
	
	// Check if the counting of questions works properly
	public void testAnswerCount() {
		Question q1 = new Question("a subject", "a body", "a author");
		Answer a1 = new Answer("a body", "a author","1");
		q1.addAnswer(a1);
		assertEquals("Answer count  is 1", 1, q1.countAnswers());
		Answer a2 = new Answer("a body", "a author","1");
		q1.addAnswer(a2);
		assertEquals("Answer count is 2", 2, q1.countAnswers());
	}
	
	// Same conditions as testAddAnswer()
	public void testAddComment() {
		Question q1 = new Question("a subject", "a body", "a author");
		Comment c1 = new Comment("a comment", "author");
		q1.addComment(c1);
		assertSame("comment object is the same", c1, q1.getComments().get(0));
		
		Comment c2 = new Comment("a comment", "author");
		q1.addComment(c2);
		assertNotSame("c1 is not c2", c1, c2);
		assertNotSame("c1 is not c2", q1.getComments().get(0), q1.getComments().get(1));
		
		q1.addComment(c2);
		assertSame("index 1 and 2 have the same comment object", q1.getComments().get(1), q1.getComments().get(2));
	}
	// This tests the getAnserByIDmethod by making sure it returns the proper answers given the answer keys.
//	public void testGetAnswerByIDMethod(){
//		Question q1 = new Question("a subject", "a body", "a author");
//		Answer a1 = new Answer("a body", "a author","1");
//		Answer a2 = new Answer("Another body", "some other author","1");
//		
//		assertTrue("An empty list doesnt return null",q1.getAnswerByID("dummy")==null);
//		q1.addAnswer(a1);
//		assertTrue("Doesnt return null with something in the list",q1.getAnswerByID("dummy")==null);
//		assertSame("The answer returned is not the same that was added",q1.getAnswerByID(a1.getId()),a1);
//		
//		q1.addAnswer(a2);
//		assertNotSame("The answers are the same",q1.getAnswerByID(a1.getId()),q1.getAnswerByID(a2.getId()));
//		
//	}
}

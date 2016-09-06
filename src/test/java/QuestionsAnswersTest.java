import static org.junit.Assert.*;

import org.junit.Test;

public class QuestionsAnswersTest {

	//test to make sure question is the right answer
	@Test
	public void checkIfQuestionGetsAdded() {
		QuestionsAnswers questionAnswer = new QuestionsAnswers();
		questionAnswer.put("How are you?", "Good");
		questionAnswer.put("What is your major?", "Computer Science");
		questionAnswer.put("How old are you?", "21");
		assertTrue(questionAnswer.testAnswer("How are you?", "Good"));
	}
	
	//Test if the hashmap is empty of question / answers
	@Test
	public void hashmapEmpty()
	{
		QuestionsAnswers questionAnswer = new QuestionsAnswers();
		questionAnswer.put("How are you?", "Good");
		questionAnswer.put("What is your major?", "Computer Science");
		questionAnswer.put("How old are you?", "21");
		assertTrue(questionAnswer.getRandomQuestion() != null);
	}

}

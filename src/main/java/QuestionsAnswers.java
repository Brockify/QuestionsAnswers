import java.util.HashMap;
import java.util.Random;

/**
* A half-secretive map of questions to answers (at most one answer per question). * Gives out random questions (keys) from the map, and
* can be queried to test if a given question maps to a given answer.
*/

public class QuestionsAnswers { /**
* Maps question to answer.
*/
	HashMap<String, String> questionAnswers = new HashMap<String, String>();
	
	void put(String question, String answer) {
		questionAnswers.put(question, answer);
	}
/**
* Queries if question maps to answer. */
	boolean testAnswer(String question, String answer) {
		boolean isFound = false;
		if(questionAnswers.containsKey(question))
		{
			if(questionAnswers.get(question) == answer)
			{
				isFound = true;
			}
		}
		return isFound;
	}
/**
* Gives out a random question from the key set. */
	String getRandomQuestion() {
		Random random = new Random();
		int questionNum = random.nextInt((questionAnswers.size()-1 - 0 + 1));		
		Object[] values = questionAnswers.values().toArray();
		Object randomValue = values[questionNum];
		return randomValue.toString();
	}
}

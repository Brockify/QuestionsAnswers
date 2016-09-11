package rest;

import java.util.HashMap;
import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import questionsanswers.QuestionsAnswers;

/**
 * REST service that greets requests.
 *
 * See:
 * https://jersey.java.net/documentation/latest/jaxrs-resources.html
 */
@Path("/")
public class QuestionAnswerService {   
	static QuestionsAnswers questionsAnswers = new QuestionsAnswers();

	public QuestionAnswerService()
	{
		questionsAnswers.add("What color is the sky?", "blue");
		questionsAnswers.add("What is 5 + 5?", "10");
		questionsAnswers.add("What is the first month of the year?", "January");
	}
	
	@GET
    @Path("/randomquestion")
    public Response randomquestion() {
		if(questionsAnswers.get().size() > 0)
		{
			return Response.ok(questionsAnswers.getRandomQuestion()).build();
		} else {
			return Response.ok("No questions added").build();
		}
    }
    
    @GET
    @Path("/testanswer")
    public Response testanswer(@QueryParam("A") String a, @QueryParam("Q") String q) {
    	System.out.println(q);
    	if(q.equals("") || q == null)
    	{
    		return Response.ok("Click random question first").build();
    	} else {
	    	boolean trueOrNot = questionsAnswers.testAnswers(q, a);
	    	if(trueOrNot)
	    	{
	    		return Response.ok("Answer is correct").build();
	    	} else {
	    		return Response.ok("Answer is not correct").build();
	    	}
    	}
    }
    
    @GET
    @Path("/addQuestion")
    public Response addQuestion(@QueryParam("question") String question,@QueryParam("answer") String answer)
    {
    	if(question.equals("") || answer.equals("")) {
    		return Response.ok("Add a question and or answer.").build();
    	} else {
	    	if(questionsAnswers.get().containsKey(question))
	    	{
	    		return Response.ok("Question already added").build();
	    	} else {
		    	questionsAnswers.add(question, answer);
		    	System.out.println(questionsAnswers.get());
	    		return Response.ok("Added Successfuly").build();
	    	}
    	}
    }
}

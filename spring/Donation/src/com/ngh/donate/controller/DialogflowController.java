package com.ngh.donate.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.api.client.util.Maps;
import com.google.cloud.dialogflow.v2.DetectIntentResponse;
import com.google.cloud.dialogflow.v2.QueryInput;
import com.google.cloud.dialogflow.v2.QueryResult;
import com.google.cloud.dialogflow.v2.SessionName;
import com.google.cloud.dialogflow.v2.SessionsClient;
import com.google.cloud.dialogflow.v2.TextInput;
import com.google.cloud.dialogflow.v2.TextInput.Builder;

@RestController
@RequestMapping("/dialogflow")
public class DialogflowController {

	/**
	 * Returns the result of detect intent with texts as inputs.
	 *
	 * Using the same `session_id` between requests allows continuation of the
	 * conversation.
	 *
	 * @param projectId    Project/Agent Id.
	 * @param texts        The text intents to be detected based on what a user
	 *                     says.
	 * @param sessionId    Identifier of the DetectIntent session.
	 * @param languageCode Language code of the query.
	 * @return The QueryResult for each input text.
	 */

	@CrossOrigin
	@GetMapping
	public static Map<String, QueryResult> detectIntentTexts() throws Exception {
		
		String projectId = "";
		List<String> texts = new ArrayList<String>();
		String sessionId = "";
		String languageCode = "";
		
		projectId = "hyun-qompfy";
		texts.add("hi");
		sessionId = "123456789";
		languageCode = "ko";
		
		
		Map<String, QueryResult> queryResults = Maps.newHashMap();
		// Instantiates a client
		try (SessionsClient sessionsClient = SessionsClient.create()) {
			// Set the session name using the sessionId (UUID) and projectID (my-project-id)
			SessionName session = SessionName.of(projectId, sessionId);
			System.out.println("Session Path: " + session.toString());

			// Detect intents for each text input
			for (String text : texts) {
				// Set the text (hello) and language code (en-US) for the query
				Builder textInput = TextInput.newBuilder().setText(text).setLanguageCode(languageCode);

				// Build the query with the TextInput
				QueryInput queryInput = QueryInput.newBuilder().setText(textInput).build();
				
				// Performs the detect intent request
				DetectIntentResponse response = sessionsClient.detectIntent(session, queryInput);

				// Display the query result
				QueryResult queryResult = response.getQueryResult();

				System.out.println("====================");
				System.out.format("Query Text: '%s'\n", queryResult.getQueryText());
				System.out.format("Detected Intent: %s (confidence: %f)\n", queryResult.getIntent().getDisplayName(),
						queryResult.getIntentDetectionConfidence());
				System.out.format("Fulfillment Text: '%s'\n", queryResult.getFulfillmentText());
				queryResults.put(text, queryResult);
								
			}
		}
		return queryResults;
	}
}

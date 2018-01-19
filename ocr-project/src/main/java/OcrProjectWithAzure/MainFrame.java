package OcrProjectWithAzure;


import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;


public class MainFrame extends JFrame {

	//Strings to build URi for REST API calls.

	private static final String uriBasePreRegion = "https://";
	private static final String uriBasePostRegion = ".api.cognitive.microsoft.com/vision/";
	private static final String uriBaseOcr = "v1.0/ocr";
	private static final String uriBaseHandwriting = "v1.0/recognizeText";


	// <editor-fold defaultstate="collapsed" desc="Variables declaration">
	// Variables declaration - do not modify//GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Statenco Dragos
	private JTabbedPane tabbedPane;
	private JPanel ocrPanel;
	private JLabel ocrTitleLabel;
	private JLabel ocrInstructionLabel;
	private JLabel ocrImagePromptLabel;
	private JTextField ocrImageUriTextBox;
	private JButton ocrImageButton;
	private JLabel ocrResponseLabel;
	private JLabel ocrSourceImageLabel;
	private JScrollPane ocrScrollPane;
	private JTextArea ocrResponseTextArea;
	private JLabel ocrImage;
	private JComboBox<String> languageSelectorComboBox;
	private JButton openButtonFile;
	private JComboBox<String> inputFileChooser;
	private JLabel laguageSelectorTextLable;
	private JPanel handwritingPanel;
	private JLabel handwritingTitleLabel;
	private JLabel handwritingInstructionLabel;
	private JLabel handwritingImagePromptLabel;
	private JTextField handwritingImageUriTextBox;
	private JButton handwritingImageButton;
	private JLabel handwritingResponseLabel;
	private JLabel handwritingSourceImageLabel;
	private JScrollPane handwritingScrollPane;
	private JTextArea handwritingResponseTextArea;
	private JLabel handwritingImage;
	private JLabel subscriptionKeyLabel;
	private JLabel subscriptionTextRegionLabel;
	private JComboBox<String> subscriptionRegionComboBox;
	private JTextField subscriptionKeyTextField;

	private MainFrame() {
		initComponents();
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	// Generated using JFormDesigner Evaluation license - Statenco Dragos
	private void initComponents() {
		tabbedPane = new JTabbedPane();
		ocrPanel = new JPanel();
		ocrTitleLabel = new JLabel();
		ocrInstructionLabel = new JLabel();
		ocrImagePromptLabel = new JLabel();
		ocrImageUriTextBox = new JTextField();
		ocrImageButton = new JButton();
		ocrResponseLabel = new JLabel();
		ocrSourceImageLabel = new JLabel();
		ocrScrollPane = new JScrollPane();
		ocrResponseTextArea = new JTextArea();
		ocrImage = new JLabel();
		languageSelectorComboBox = new JComboBox<>();
		openButtonFile = new JButton();
		inputFileChooser = new JComboBox<>();
		laguageSelectorTextLable = new JLabel();
		handwritingPanel = new JPanel();
		handwritingTitleLabel = new JLabel();
		handwritingInstructionLabel = new JLabel();
		handwritingImagePromptLabel = new JLabel();
		handwritingImageUriTextBox = new JTextField();
		handwritingImageButton = new JButton();
		handwritingResponseLabel = new JLabel();
		handwritingSourceImageLabel = new JLabel();
		handwritingScrollPane = new JScrollPane();
		handwritingResponseTextArea = new JTextArea();
		handwritingImage = new JLabel();
		subscriptionKeyLabel = new JLabel();
		subscriptionTextRegionLabel = new JLabel();
		subscriptionRegionComboBox = new JComboBox<>();
		subscriptionKeyTextField = new JTextField();

		//======== this ========
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(960, 600));
		Container contentPane = getContentPane();

		//======== tabbedPane ========
		{

			//======== ocrPanel ========
			{

				// JFormDesigner evaluation mark
				ocrPanel.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0), "Statenco Dragos-Alexandru Trademark", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new Font("Dialog", Font.BOLD, 12), Color.red), ocrPanel.getBorder()));
				ocrPanel.addPropertyChangeListener(e -> {
					if("border".equals(e.getPropertyName())) throw new RuntimeException();
				});


				//---- ocrTitleLabel ----
				ocrTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
				ocrTitleLabel.setText("Optical Character Recognition (OCR):");

				//---- ocrInstructionLabel ----
				ocrInstructionLabel.setText("Enter the URL or location to an image of printed text, then click the \"Read Image\" button.");

				//---- ocrImagePromptLabel ----
				ocrImagePromptLabel.setText("Image to read:");

				//---- ocrImageButton ----
				ocrImageButton.setText("Read Image");
				ocrImageButton.addActionListener(this::ocrImageButtonActionPerformed);

				//---- ocrResponseLabel ----
				ocrResponseLabel.setText("Response:");

				//---- ocrSourceImageLabel ----
				ocrSourceImageLabel.setText("Source image:");

				//======== ocrScrollPane ========
				{

					//---- ocrResponseTextArea ----
					ocrResponseTextArea.setEditable(false);
					ocrResponseTextArea.setColumns(20);
					ocrResponseTextArea.setRows(5);
					ocrScrollPane.setViewportView(ocrResponseTextArea);
				}

				//---- languageSelectorComboBox ----
				languageSelectorComboBox.setSelectedIndex(- 1);
				languageSelectorComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"ro", "unk"}));
				languageSelectorComboBox.setToolTipText("<html>" + "ro - Romanian" + "<br>" + "\nunk - Auto-Detect language" + "</html>");

				//---- openButtonFile ----
				openButtonFile.setText("Open");
				openButtonFile.addActionListener(this::ocrImageOpenButtonActionPerformed);

				//---- inputFileChooser ----
				inputFileChooser.setModel(new DefaultComboBoxModel<>(new String[]{"application/octet-stream", "application/json"}));
				inputFileChooser.setToolTipText("<html>" + "Application/octet-stream -> Select file from local source;" + "<br>" + "Application/json -> Select file from URL;" + "</html>");

				//---- laguageSelectorTextLable ----
				laguageSelectorTextLable.setText("Language selector");

				GroupLayout ocrPanelLayout = new GroupLayout(ocrPanel);
				ocrPanel.setLayout(ocrPanelLayout);
				ocrPanelLayout.setHorizontalGroup(ocrPanelLayout.createParallelGroup().addGroup(ocrPanelLayout.createSequentialGroup().addContainerGap().addGroup(ocrPanelLayout.createParallelGroup().addGroup(ocrPanelLayout.createSequentialGroup().addGroup(ocrPanelLayout.createParallelGroup().addComponent(ocrScrollPane, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE).addComponent(ocrResponseLabel)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(ocrPanelLayout.createParallelGroup().addComponent(ocrSourceImageLabel).addComponent(ocrImage, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))).addGroup(ocrPanelLayout.createSequentialGroup().addGroup(ocrPanelLayout.createParallelGroup().addGroup(ocrPanelLayout.createSequentialGroup().addComponent(ocrImagePromptLabel).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(ocrImageUriTextBox, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(ocrImageButton).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(openButtonFile, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(inputFileChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGroup(ocrPanelLayout.createSequentialGroup().addGroup(ocrPanelLayout.createParallelGroup().addComponent(ocrTitleLabel).addComponent(ocrInstructionLabel)).addGap(18, 18, 18).addGroup(ocrPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(languageSelectorComboBox, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE).addComponent(laguageSelectorTextLable, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)))).addGap(0, 202, Short.MAX_VALUE))).addContainerGap()));
				ocrPanelLayout.setVerticalGroup(ocrPanelLayout.createParallelGroup().addGroup(ocrPanelLayout.createSequentialGroup().addContainerGap().addGroup(ocrPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(ocrTitleLabel).addComponent(laguageSelectorTextLable)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(ocrPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(languageSelectorComboBox, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE).addComponent(ocrInstructionLabel, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(ocrPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(inputFileChooser).addGroup(ocrPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(ocrImagePromptLabel).addComponent(ocrImageUriTextBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(ocrImageButton).addComponent(openButtonFile))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(ocrPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(ocrResponseLabel).addComponent(ocrSourceImageLabel)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(ocrPanelLayout.createParallelGroup().addComponent(ocrImage, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(ocrScrollPane, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)).addContainerGap()));
			}
			tabbedPane.addTab("OCR", ocrPanel);

			//======== handwritingPanel ========
			{

				//---- handwritingTitleLabel ----
				handwritingTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
				handwritingTitleLabel.setText("Read handwritten text:");

				//---- handwritingInstructionLabel ----
				handwritingInstructionLabel.setText("Enter the URL to an image of handwritten text, then click the \"Read Image\" button.");

				//---- handwritingImagePromptLabel ----
				handwritingImagePromptLabel.setText("Image to read:");

				//---- handwritingImageButton ----
				handwritingImageButton.setText("Read Image");
				handwritingImageButton.addActionListener(e -> handwritingImageButtonActionPerformed());

				//---- handwritingResponseLabel ----
				handwritingResponseLabel.setText("Response:");

				//---- handwritingSourceImageLabel ----
				handwritingSourceImageLabel.setText("Source image:");

				//======== handwritingScrollPane ========
				{

					//---- handwritingResponseTextArea ----
					handwritingResponseTextArea.setEditable(false);
					handwritingResponseTextArea.setColumns(20);
					handwritingResponseTextArea.setRows(5);
					handwritingScrollPane.setViewportView(handwritingResponseTextArea);
				}

				GroupLayout handwritingPanelLayout = new GroupLayout(handwritingPanel);
				handwritingPanel.setLayout(handwritingPanelLayout);
				handwritingPanelLayout.setHorizontalGroup(handwritingPanelLayout.createParallelGroup().addGroup(handwritingPanelLayout.createSequentialGroup().addContainerGap().addGroup(handwritingPanelLayout.createParallelGroup().addGroup(handwritingPanelLayout.createSequentialGroup().addGroup(handwritingPanelLayout.createParallelGroup().addComponent(handwritingTitleLabel).addComponent(handwritingInstructionLabel).addGroup(handwritingPanelLayout.createSequentialGroup().addComponent(handwritingImagePromptLabel).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(handwritingImageUriTextBox, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(handwritingImageButton))).addGap(0, 0, Short.MAX_VALUE)).addGroup(handwritingPanelLayout.createSequentialGroup().addGroup(handwritingPanelLayout.createParallelGroup().addComponent(handwritingScrollPane, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE).addComponent(handwritingResponseLabel)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(handwritingPanelLayout.createParallelGroup().addComponent(handwritingSourceImageLabel).addComponent(handwritingImage, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))).addContainerGap()));
				handwritingPanelLayout.setVerticalGroup(handwritingPanelLayout.createParallelGroup().addGroup(handwritingPanelLayout.createSequentialGroup().addContainerGap().addComponent(handwritingTitleLabel).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(handwritingInstructionLabel).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(handwritingPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(handwritingImagePromptLabel).addComponent(handwritingImageUriTextBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(handwritingImageButton)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(handwritingPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(handwritingResponseLabel).addComponent(handwritingSourceImageLabel)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(handwritingPanelLayout.createParallelGroup().addComponent(handwritingImage, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(handwritingScrollPane, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)).addContainerGap()));
			}
			tabbedPane.addTab("Read Handwritten Text", handwritingPanel);
		}

		//---- subscriptionKeyLabel ----
		subscriptionKeyLabel.setText("Subscription Key:");

		//---- subscriptionTextRegionLabel ----
		subscriptionTextRegionLabel.setText("Subscription Region:");

		//---- subscriptionRegionComboBox ----
		subscriptionRegionComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"westeurope"}));

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(contentPaneLayout.createParallelGroup().addGroup(contentPaneLayout.createSequentialGroup().addContainerGap().addComponent(subscriptionKeyLabel).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(subscriptionKeyTextField).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(subscriptionTextRegionLabel).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(subscriptionRegionComboBox, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)).addGroup(contentPaneLayout.createSequentialGroup().addComponent(tabbedPane).addContainerGap()));
		contentPaneLayout.setVerticalGroup(contentPaneLayout.createParallelGroup().addGroup(contentPaneLayout.createSequentialGroup().addContainerGap().addComponent(tabbedPane).addGap(12, 12, 12).addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(subscriptionKeyLabel).addComponent(subscriptionTextRegionLabel).addComponent(subscriptionRegionComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(subscriptionKeyTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGap(24, 24, 24)));
		pack();
		setLocationRelativeTo(getOwner());
	}// </editor-fold>//GEN-END:initComponents

	private JSONObject HandwritingImage(String imageUrl) {
		try(CloseableHttpClient textClient = HttpClientBuilder.create().build(); CloseableHttpClient resultClient = HttpClientBuilder.create().build()){
			// Create the URI to access the REST API call to read text in an image.
			String uriString = uriBasePreRegion + String.valueOf(subscriptionRegionComboBox.getSelectedItem()) + uriBasePostRegion + uriBaseHandwriting;
			URIBuilder uriBuilder = new URIBuilder(uriString);

			// Request parameters.
			uriBuilder.setParameter("handwriting", "true");

			// Prepare the URI for the REST API call.
			URI uri = uriBuilder.build();
			HttpPost request = new HttpPost(uri);

			// Request headers.
			request.setHeader("Content-Type", "application/json");
			request.setHeader("Ocp-Apim-Subscription-Key", subscriptionKeyTextField.getText());

			// Request body.

			StringEntity reqEntity = new StringEntity("{\"url\":\"" + imageUrl + "\"}");
			request.setEntity(reqEntity);

			// Execute the REST API call and get the response.
			HttpResponse textResponse = textClient.execute(request);

			// Check for success.
			if(textResponse.getStatusLine().getStatusCode() != 202){
				// An error occured. Return the JSON error message.
				HttpEntity entity = textResponse.getEntity();
				String jsonString = EntityUtils.toString(entity);
				return new JSONObject(jsonString);

			}

			String operationLocation = null;

			// The 'Operation-Location' in the response contains the URI to retrieve the recognized text.
			Header[] responseHeaders = textResponse.getAllHeaders();
			for(Header header : responseHeaders){
				if(header.getName().equals("Operation-Location")){
					// This string is the URI where you can get the text recognition operation result.
					operationLocation = header.getValue();
					break;
				}
			}

			// NOTE: The response may not be immediately available. Handwriting recognition is an
			// async operation that can take a variable amount of time depending on the length
			// of the text you want to recognize. You may need to wait or retry this operation.
			//
			// This example checks once per second for ten seconds.

			JSONObject responseObj = null;
			do{
				// Wait one second.
				Thread.sleep(1000);

				// Check to see if the operation completed.
				HttpGet resultRequest = new HttpGet(operationLocation);
				resultRequest.setHeader("Ocp-Apim-Subscription-Key", subscriptionKeyTextField.getText());
				HttpResponse resultResponse = resultClient.execute(resultRequest);
				HttpEntity responseEntity = resultResponse.getEntity();
				if(responseEntity != null){
					// Get the JSON response.
					String jsonString = EntityUtils.toString(responseEntity);
					responseObj = new JSONObject(jsonString);
				}
			}while(responseObj != null && ! responseObj.getString("status").equalsIgnoreCase("Succeeded"));

			// If the operation completed, return the JSON object.
			if(responseObj != null){
				return responseObj;
			}else{
				// Return null for timeout error.
				System.out.println("Timeout error.");
				return null;
			}
		}catch(Exception e){
			// Display error message.
			System.out.println(e.getMessage());
			return null;
		}
	}

	private JSONObject OcrImage(String imageUrl) {
		try(CloseableHttpClient httpclient = HttpClientBuilder.create().build()){
			// Create the URI to access the REST API call to read text in an image.
			String uriString = uriBasePreRegion + String.valueOf(subscriptionRegionComboBox.getSelectedItem()) + uriBasePostRegion + uriBaseOcr;
			URIBuilder uriBuilder = new URIBuilder(uriString);

			// Request parameters.
			uriBuilder.setParameter("language", String.valueOf(languageSelectorComboBox.getSelectedItem()));
			uriBuilder.setParameter("detectOrientation ", "true");

			// Prepare the URI for the REST API call.
			URI uri = uriBuilder.build();
			HttpPost request = new HttpPost(uri);

			// Request headers.

			request.setHeader("Content-Type", String.valueOf(inputFileChooser.getSelectedItem()));
			request.setHeader("Ocp-Apim-Subscription-Key", subscriptionKeyTextField.getText());

			// Request body.

			StringEntity reqEntity = new StringEntity("{\"url\":\"" + imageUrl + "\"}");
			request.setEntity(reqEntity);

			// Execute the REST API call and get the response entity.
			HttpResponse response = httpclient.execute(request);
			HttpEntity entity = response.getEntity();

			// If we got a response, parse it and display it.
			if(entity != null){
				// Return the JSONObject.
				String jsonString = EntityUtils.toString(entity);


				return new JSONObject(jsonString);

			}else{
				// No response. Return null.
				return null;
			}
		}catch(Exception e){
			// Display error message.
			System.out.println(e.getMessage());
			return null;
		}
	}

	private JSONObject OcrImage(File imageUrl) {
		try(CloseableHttpClient httpclient = HttpClientBuilder.create().build()){
			// Create the URI to access the REST API call to read text in an image.
			String uriString = uriBasePreRegion + String.valueOf(subscriptionRegionComboBox.getSelectedItem()) + uriBasePostRegion + uriBaseOcr;
			URIBuilder uriBuilder = new URIBuilder(uriString);

			// Request parameters.
			uriBuilder.setParameter("language", String.valueOf(languageSelectorComboBox.getSelectedItem()));
			uriBuilder.setParameter("detectOrientation ", "true");

			// Prepare the URI for the REST API call.
			URI uri = uriBuilder.build();
			HttpPost request = new HttpPost(uri);

			// Request headers.

			request.setHeader("Content-Type", String.valueOf(inputFileChooser.getSelectedItem()));
			request.setHeader("Ocp-Apim-Subscription-Key", subscriptionKeyTextField.getText());

			// Request body.

			FileEntity reqEntity = new FileEntity(imageUrl);
			request.setEntity(reqEntity);

			// Execute the REST API call and get the response entity.
			HttpResponse response = httpclient.execute(request);
			HttpEntity entity = response.getEntity();

			// If we got a response, parse it and display it.
			if(entity != null){
				// Return the JSONObject.
				String jsonString = EntityUtils.toString(entity);


				return new JSONObject(jsonString);

			}else{
				// No response. Return null.
				return null;
			}
		}
		catch(IOException | URISyntaxException e){
			//Display error message.
			e.printStackTrace();
			return null;
		}
	}

	private void handwritingImageButtonActionPerformed() {//GEN-FIRST:event_handwritingImageButtonActionPerformed
		URL handwritingImageUrl;

		// Clear out the previous image, response, and caption, if any.
		handwritingImage.setIcon(new ImageIcon());
		handwritingResponseTextArea.setText("");

		// Display the image specified in the text box.
		try{
			handwritingImageUrl = new URL(handwritingImageUriTextBox.getText());
			BufferedImage bImage = ImageIO.read(handwritingImageUrl);
			scaleAndShowImage(bImage, handwritingImage);
		}catch(IOException e){
			handwritingResponseTextArea.setText("Error loading Handwriting image: " + e.getMessage());
			return;
		}

		// Read the text in the image.
		JSONObject jsonObj = HandwritingImage(handwritingImageUrl.toString());

		// A return of null indicates failure.
		if(jsonObj == null){
			return;
		}

		// Format and display the JSON response.
		handwritingResponseTextArea.setText(jsonObj.toString(2));
	}//GEN-LAST:event_handwritingImageButtonActionPerformed

	private void ocrImageButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_ocrImageButtonActionPerformed

		URL ocrImageUrl;


		// Clear out the previous image, response, and caption, if any.
		ocrImage.setIcon(new ImageIcon());
		ocrResponseTextArea.setText("");

		// Display the image specified in the text box.
		try{
			ocrImageUrl = new URL(ocrImageUriTextBox.getText());
			BufferedImage bImage = ImageIO.read(ocrImageUrl);
			scaleAndShowImage(bImage, ocrImage);
		}catch(IOException e){
			ocrResponseTextArea.setText("Error loading OCR image: " + e.getMessage());
			return;
		}

		// Read the text in the image.
		JSONObject jsonObj = OcrImage(ocrImageUrl.toString());

		// A return of null indicates failure.
		if(jsonObj == null)

		{
			return;
		}
		System.out.println(jsonObj.toString(2));
		// Format and display the JSON response.
		ArrayList<String> lines = extractLines(jsonObj);


		ocrResponseTextArea.setText(String.join(" ", lines));

	} //GEN-LAST:event_ocrImageButtonActionPerformed

	private void ocrImageOpenButtonActionPerformed(ActionEvent etv) {//GEN-FIRST:event_ocrImageButtonActionPerformed

		File ocrImageUrl;


		JFileChooser chooser = new JFileChooser();

		if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			File f = chooser.getSelectedFile();
			ocrImageUriTextBox.setText(f.getAbsolutePath());

		} else {
			System.out.println("Something went wrong.");
		}



		// Clear out the previous image, response, and caption, if any.
		ocrImage.setIcon(new ImageIcon());
		ocrResponseTextArea.setText("");

		// Display the image specified in the text box.
		try{
			ocrImageUrl = new File(ocrImageUriTextBox.getText());
			BufferedImage bImage = ImageIO.read(ocrImageUrl);
			scaleAndShowImage(bImage, ocrImage);
		}catch(IOException e){
			ocrResponseTextArea.setText("Error loading OCR image: " + e.getMessage());
			return;
		}

		// Read the text in the image.
		JSONObject jsonObj = OcrImage(ocrImageUrl);

		// A return of null indicates failure.
		if(jsonObj == null)

		{
			return;
		}
		System.out.println(jsonObj.toString(2));
		// Format and display the JSON response.
		ArrayList<String> lines = extractLines(jsonObj);


		ocrResponseTextArea.setText(String.join(" ", lines));
	}//GEN-LAST:event_ocrImageButtonActionPerformed

    private ArrayList<String> extractLines(JSONObject object) {
		ArrayList<String> wordsList = new ArrayList<>();

		JSONObject regions = object.getJSONArray("regions").getJSONObject(0);

		JSONArray lines = regions.getJSONArray("lines");
		for(int i = 0; i < lines.length(); i++){
			JSONObject line = lines.getJSONObject(i);

			JSONArray words = line.getJSONArray("words");
			for(int j = 0; j < words.length(); j++){
				JSONObject word = words.getJSONObject(j);
				wordsList.add(word.getString("text"));
			}

		}


		return wordsList;
	}

	private void scaleAndShowImage(BufferedImage bImage, JLabel label) {
		int bImageHeight = bImage.getHeight();
		int bImageWidth = bImage.getWidth();
		int labelHeight = label.getHeight();
		int labelWidth = label.getWidth();

		// Does this need to be scaled?
		if(labelHeight >= bImageHeight && labelWidth >= bImageWidth){
			// If not, display the image and return.
			ImageIcon image = new ImageIcon(bImage);
			label.setIcon(image);
			return;
		}

		// Calculate the new width and height for the image.
		int newHeight;
		int newWidth;
		double bImageAspect = (double) bImageHeight / (double) bImageWidth;
		double labelAspect = (double) labelHeight / (double) labelWidth;

		if(bImageAspect > labelAspect){
			newHeight = labelHeight;
			newWidth = (int) (((double) labelHeight / (double) bImageHeight) * (double) bImageWidth);
		}else{
			newWidth = labelWidth;
			newHeight = (int) (((double) labelWidth / (double) bImageWidth) * (double) bImageHeight);
		}

		// Create a new image scaled to the correct size.
		Image newImage = bImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

		// Display the scaled image.
		ImageIcon labelImage = new ImageIcon(newImage);
		label.setIcon(labelImage);
		label.validate();
		label.repaint();
	}

	public static void main(String args[]) {
	    /* Set the Nimbus look and feel */
		//<editor-fold default state="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
		try{
			for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
				if("Nimbus".equals(info.getName())){
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		}catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex){
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

        /* Create and display the form */
		EventQueue.invokeLater(() -> new MainFrame().setVisible(true));
	}
}


		// End of variables declaration//GEN-END:variables
		// </editor-fold>



package io.openbdt.start;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

import org.apache.velocity.runtime.directive.Foreach;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.openbdt.model.Feature;
import io.openbdt.util.DataBind;
public class StartParseJackson {

	public static void main(String[] args) {

//		final String jsonFile = "C:\\Users\\Public\\reports\\furo.json";
//		final String jsonFile = "C:\\Users\\Public\\reports\\THI1.json";
//		final String jsonFile = "C:\\Users\\Public\\reports\\THI2.json";
//		final String jsonFile = "C:\\Users\\Public\\reports\\THI3.json";
		final String jsonFile = "C:\\Users\\Public\\reports\\THI5.json";
//		final String jsonFile = "C:\\Users\\Public\\reports\\report-serenity-new.json";

		try (Reader reader = new InputStreamReader(new FileInputStream(jsonFile), StandardCharsets.UTF_8)) {

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			// this prevents printing eg. 2.20 as 2.2
			mapper.enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);

			Feature feature = mapper.readValue(reader, Feature.class);
			
			System.out.println(feature);
			
//			DataBind dataBind = new DataBind(feature);
//			dataBind.process();
//			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

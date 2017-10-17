package io.openbdt.start;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TesteJson {

	public static void main(String[] args) {

		// String jsonString = "{\"nome\":\"Caio\",\"idade\":\"28\", \"sexo\":
		// \"masculino\"}";

	
			
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            
		/*	try {
				List<Element> list = mapper.readValue( new File("C:\\Users\\Public\\reports\\report-serenity-new.json") , new TypeReference<ArrayList<Element>>(){});
		
				List<Step> list2 = mapper.readValue( new File("C:\\Users\\Public\\reports\\report-serenity-new.json") , new TypeReference<ArrayList<Step>>(){});
				
				List<Result> list3 = mapper.readValue( new File("C:\\Users\\Public\\reports\\report-serenity-new.json") , new TypeReference<ArrayList<Result>>(){});
				
				for (Result step : list3) {
					
					System.out.println(list3);
					
//					System.out.println(">> " + step.getAdditionalProperties());
					
					Object object = step.getAdditionalProperties().get("elements");
					
					if (object instanceof ArrayList) {
						
						List listTest = (List) object;
						
						for (Object ob : listTest) {
							
							Map<Object, Object> mp = (Map<Object, Object>) ob;
							
//							mp.get("steps")
							
//							System.out.println(mp);
							
							mp.get("steps");
							
							
							System.out.println();
						} 	
						
					}
					
//					LinkedHashMap<String, ArrayList> linkedHashMap = new  LinkedHashMap<String, ArrayList>() ;
					
//					linkedHashMap =  (LinkedHashMap<String, ArrayList>) step.getAdditionalProperties().get("elements");
					
					
				}
				
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
			// JsonReader reader = new JsonReader(new
			// FileReader("C:\\Users\\Public\\reports\\report-serenity-new.json"));

			/*BufferedReader bufferedReader = new BufferedReader(
					new FileReader("C:\\Users\\Public\\reports\\report-serenity-new.json"));

			Gson gson = new Gson();

			
			 * Element[] element = gson.fromJson(reader, Element[].class);
			 * 
			 * for (Element el : element) { System.out.println(el); }
			 

			Element[] element = gson.fromJson(bufferedReader, Element[].class);

			for (Element elm : element) {
				System.out.println(elm.toString());
			}

			Step step = gson.fromJson(bufferedReader, Step.class);


//				System.out.println(step.toString());


			Match match = gson.fromJson(bufferedReader, Match.class);

			for (Match ma : match) {
				System.out.println(ma.toString());
			}

			Example example = gson.fromJson(bufferedReader, Example.class);
			
			System.out.println(example.toString());*/
			/*for (Example ex : example) {
				System.out.println(ex.toString());
			}*/

			/*
			 * Argument arg = gson.fromJson(reader, Argument.class);
			 * 
			 * System.out.println(arg.toString());
			 */

			// Post post = gson.fromJson(reader, Post.class);

			/*
			 * for (Argument argu : arg) { System.out.println(argu.toString()); }
			 */

			/*
			 * 
			 * 
			 * Match[] match = gson.fromJson(reader, Match[].class); for (Match ma : match)
			 * { System.out.println(ma.toString()); }
			 * 
			 * Result[] res = gson.fromJson(reader, Result[].class); for (Result re : res) {
			 * System.out.println(re.toString()); }
			 * 
			 */

	

	}
}

class Foo<T> {
	T value;
}

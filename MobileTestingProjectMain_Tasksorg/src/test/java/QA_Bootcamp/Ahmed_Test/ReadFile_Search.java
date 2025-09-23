package QA_Bootcamp.Ahmed_Test;

import org.testng.annotations.DataProvider;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReadFile_Search {

	@DataProvider(name = "Search_Bar_Test_Data")
	public Object[][] getCSVTestData() throws IOException {
		List<Object[]> data = new ArrayList<>();

		InputStream isThread = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("Data/Data_Search.CSV");

		BufferedReader buffR = new BufferedReader(new InputStreamReader(isThread));
		String line;
		boolean firstLine = true;

		while ((line = buffR.readLine()) != null) {
			if (firstLine) {
				firstLine = false;
				continue;
			}

			String[] values = line.split(",");
			String taskName = values.length > 0 ? values[0] : "";
			String result = values.length > 1 ? values[1] : "";

			data.add(new Object[] { taskName, result });
		}

		return data.toArray(new Object[0][]);
	}

	@DataProvider(name = "Search_Reset_Test_Data")
	public Object[][] getCSVTestDataForReset() throws IOException {
		List<Object[]> data = new ArrayList<>();

		InputStream isThread = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("Data/Data_Search_Reset.CSV");

		BufferedReader buffR = new BufferedReader(new InputStreamReader(isThread));
		String line;
		boolean firstLine = true;

		while ((line = buffR.readLine()) != null) {
			if (firstLine) {
				firstLine = false;
				continue;
			}

			String[] values = line.split(",");
			String taskName = values.length > 0 ? values[0] : "";
			String result = values.length > 1 ? values[1] : "";

			data.add(new Object[] { taskName, result });
		}

		return data.toArray(new Object[0][]);
	}
}
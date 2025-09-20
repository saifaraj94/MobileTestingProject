package WF_Ahmed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

public class ReadFile_Sorting {

	@DataProvider(name = "Sorting_Data")
	public Object[][] getCSVTestData() throws IOException {
		List<Object[]> data = new ArrayList<>();

		InputStream isThread = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("Data/Data_Sorting.CSV");

		if (isThread == null) {
			throw new IOException("CSV file not found in resources/Data/Data_Sorting.CSV");
		}

		BufferedReader buffR = new BufferedReader(new InputStreamReader(isThread));
		String line;
		boolean firstLine = true;

		while ((line = buffR.readLine()) != null) {
			if (firstLine) {
				firstLine = false;
				continue;
			}

			String[] values = line.split(",");
			if (values.length < 8) {
				throw new IllegalArgumentException("CSV row does not have 8 columns: " + line);
			}

			String groupingOption = values[0];
			boolean groupingAsc = Boolean.parseBoolean(values[1]);
			String sortingOption = values[2];
			boolean sortingAsc = Boolean.parseBoolean(values[3]);
			String subtaskOption = values[4];
			boolean subtaskAsc = Boolean.parseBoolean(values[5]);
			String completedOption = values[6];
			boolean completedAsc = Boolean.parseBoolean(values[7]);

			data.add(new Object[] { groupingOption, groupingAsc, sortingOption, sortingAsc, subtaskOption, subtaskAsc,
					completedOption, completedAsc });
		}

		buffR.close();
		return data.toArray(new Object[0][]);
	}
}

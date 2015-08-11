package org.sonarsource.escoem;

import java.util.Arrays;
import java.util.List;
import org.sonar.api.measures.AverageFormula;
import org.sonar.api.measures.CoreMetrics;
import org.sonar.api.measures.Metric;
import org.sonar.api.measures.Metric.Builder;
import org.sonar.api.measures.Metric.ValueType;
import org.sonar.api.measures.Metrics;
import org.sonar.api.measures.SumChildValuesFormula;

public final class OnedMetrics implements Metrics {
	public static final String DANGEROUS_FILES_KEY = "dangerous_files";
	public static final Metric<Double> DANGEROUS_FILES = new Metric.Builder("dangerous_files", "Dangerous Files",
			Metric.ValueType.INT).setDescription("Dangerous Files").setDirection(Integer.valueOf(-1))
					.setQualitative(Boolean.valueOf(true)).setDomain(CoreMetrics.DOMAIN_COMPLEXITY)
					.setFormula(new SumChildValuesFormula(false)).setDeleteHistoricalData(true).create();
	public static final String DANGEROUS_COMPLEXITY_KEY = "dangerous_complexity";
	public static final Metric<Double> DANGEROUS_COMPLEXITY = new Metric.Builder("dangerous_complexity",
			"Dangerous Complexity", Metric.ValueType.INT).setDescription("Dangerous File")
					.setDirection(Integer.valueOf(-1)).setQualitative(Boolean.valueOf(true))
					.setDomain(CoreMetrics.DOMAIN_COMPLEXITY).setFormula(new SumChildValuesFormula(false))
					.setDeleteHistoricalData(true).create();
	public static final String DANGEROUS_FILE_COMPLEXITY_KEY = "dangerous_file_complexity";
	public static final Metric<Double> DANGEROUS_FILE_COMPLEXITY = new Metric.Builder("dangerous_file_complexity",
			"Dangerous Complexity /file", Metric.ValueType.FLOAT).setDescription("Dangerous Complexity average by file")
					.setDirection(Integer.valueOf(-1)).setQualitative(Boolean.valueOf(true))
					.setDomain(CoreMetrics.DOMAIN_COMPLEXITY)
					.setFormula(AverageFormula.create(DANGEROUS_COMPLEXITY, DANGEROUS_FILES)).create();

	public List<Metric> getMetrics() {
		return Arrays.asList(new Metric[] { DANGEROUS_FILES, DANGEROUS_COMPLEXITY, DANGEROUS_FILE_COMPLEXITY });
	}
}

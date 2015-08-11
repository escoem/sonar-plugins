package org.sonarsource.escoem;

import java.util.Arrays;
import java.util.List;
import org.sonar.api.Properties;
import org.sonar.api.SonarPlugin;

@Properties({
		@org.sonar.api.Property(key = "sonar.escoem.oned.threshold", name = "Threshold", description = "File Complexity Threshold", defaultValue = "20.9") })
public final class OnedPlugin extends SonarPlugin {
	public static final String THRESHOLD = "sonar.escoem.oned.threshold";

	public List getExtensions() {
		return Arrays.asList(new Class[] { OnedMetrics.class, OnedFileDecorator.class, OnedComplexDecorator.class });
	}
}

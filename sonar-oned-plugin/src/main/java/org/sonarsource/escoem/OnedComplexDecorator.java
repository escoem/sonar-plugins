package org.sonarsource.escoem;

import org.sonar.api.batch.Decorator;
import org.sonar.api.batch.DecoratorContext;
import org.sonar.api.config.Settings;
import org.sonar.api.measures.CoreMetrics;
import org.sonar.api.measures.Measure;
import org.sonar.api.resources.Project;
import org.sonar.api.resources.Resource;
import org.sonar.api.resources.ResourceUtils;

public class OnedComplexDecorator implements Decorator {
	private final double threshold;

	public OnedComplexDecorator(Settings settings) {
		this.threshold = settings.getFloat("sonar.escoem.oned.threshold").floatValue();
	}

	public boolean shouldExecuteOnProject(Project project) {
		return true;
	}

	public void decorate(Resource resource, DecoratorContext context) {
		if (ResourceUtils.isEntity(resource)) {
			Measure complexity = context.getMeasure(CoreMetrics.COMPLEXITY);
			double value = complexity.getValue().doubleValue();
			if (value > this.threshold) {
				context.saveMeasure(OnedMetrics.DANGEROUS_COMPLEXITY, Double.valueOf(value));
				context.saveMeasure(OnedMetrics.DANGEROUS_FILE_COMPLEXITY, Double.valueOf(value));
			}
		}
	}
}

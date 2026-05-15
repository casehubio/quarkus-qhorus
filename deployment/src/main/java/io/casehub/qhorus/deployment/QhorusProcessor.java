package io.casehub.qhorus.deployment;

import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.FeatureBuildItem;

/**
 * Quarkus build-time processor for the Qhorus extension.
 *
 * Reactive vs blocking stack selection is governed by:
 *   quarkus.datasource.qhorus.reactive=true  → reactive beans active (via @IfBuildProperty)
 *   quarkus.datasource.qhorus.reactive=false (default) → blocking beans active (via @UnlessBuildProperty)
 *
 * quarkus-hibernate-reactive-panache is <optional> in runtime/pom.xml — consumers
 * who do not need reactive get zero activation with zero workaround properties.
 * See PP-20260514-f41258.
 */
class QhorusProcessor {

    private static final String FEATURE = "qhorus";

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }
}

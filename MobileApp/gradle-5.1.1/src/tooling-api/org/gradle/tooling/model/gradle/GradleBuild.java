/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.tooling.model.gradle;

import org.gradle.api.Incubating;
import org.gradle.tooling.model.BuildIdentifier;
import org.gradle.tooling.model.BuildModel;
import org.gradle.tooling.model.DomainObjectSet;
import org.gradle.tooling.model.Model;

/**
 * Provides information about the structure of a Gradle build.
 *
 * @since 1.8
 */
public interface GradleBuild extends Model, BuildModel {
    /**
     * Returns the identifier for this Gradle build.
     *
     * @since 2.13
     */
    BuildIdentifier getBuildIdentifier();

    /**
     * Returns the root project for this build.
     *
     * @return The root project
     */
    BasicGradleProject getRootProject();

    /**
     * Returns the set of all projects for this build.
     *
     * @return The set of all projects.
     */
    DomainObjectSet<? extends BasicGradleProject> getProjects();

    /**
     * Returns the included builds that were referenced by this build. This is the set of builds that were directly included by this build via its {@link org.gradle.api.initialization.Settings} instance.
     *
     * @since 3.3
     */
    DomainObjectSet<? extends GradleBuild> getIncludedBuilds();

    /**
     * Returns all builds contained in this build for which tooling models should be built when importing into an IDE.
     *
     * <p>This is not always the same the builds returned by {@link #getIncludedBuilds()}. For the root build, the 'editable' builds set contains all builds that participate in the composite build, including those directly included by the root build plus all builds included by any nested included builds transitively. For all other builds, this set is empty.</p>
     *
     * @since 4.10
     */
    @Incubating
    DomainObjectSet<? extends GradleBuild> getEditableBuilds();
}

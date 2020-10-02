plugins {
    base
}

tasks {
    register("workingTask") {
        doLast {
            project.copy {
                from("template.txt")
                into("$buildDir")
                // Multiple entries in the map; "foo" is not used in the template:
                expand(mapOf("templateVar" to "Some content", "foo" to "bar"))
            }
        }
    }

    register("failingTask") {
        doLast {
            project.copy {
                from("template.txt")
                into("$buildDir")
                // Only one entry in the map:
                expand(mapOf("templateVar" to "Some content"))
            }
        }
    }
}

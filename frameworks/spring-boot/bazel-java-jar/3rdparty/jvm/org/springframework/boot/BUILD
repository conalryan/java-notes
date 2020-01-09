java_library(
    name = "spring_boot",
    exports = [
        "//3rdparty/jvm/org/springframework:spring_context",
        "//3rdparty/jvm/org/springframework:spring_core",
        "//external:jar/org/springframework/boot/spring_boot"
    ],
    visibility = [
        "//3rdparty/jvm:__subpackages__"
    ]
)



java_library(
    name = "spring_boot_autoconfigure",
    exports = [
        "//external:jar/org/springframework/boot/spring_boot_autoconfigure",
        ":spring_boot"
    ],
    visibility = [
        "//3rdparty/jvm:__subpackages__"
    ]
)



java_library(
    name = "spring_boot_starter",
    exports = [
        "//3rdparty/jvm/org/springframework:spring_core",
        "//3rdparty/jvm/org/yaml:snakeyaml",
        "//external:jar/org/springframework/boot/spring_boot_starter",
        ":spring_boot",
        ":spring_boot_autoconfigure",
        ":spring_boot_starter_logging"
    ],
    visibility = [
        "//3rdparty/jvm:__subpackages__"
    ]
)



java_library(
    name = "spring_boot_starter_logging",
    exports = [
        "//3rdparty/jvm/ch/qos/logback:logback_classic",
        "//3rdparty/jvm/org/slf4j:jcl_over_slf4j",
        "//3rdparty/jvm/org/slf4j:jul_to_slf4j",
        "//3rdparty/jvm/org/slf4j:log4j_over_slf4j",
        "//external:jar/org/springframework/boot/spring_boot_starter_logging"
    ],
    visibility = [
        "//3rdparty/jvm:__subpackages__"
    ]
)



java_library(
    name = "spring_boot_starter_test",
    exports = [
        "//3rdparty/jvm/com/jayway/jsonpath:json_path",
        "//3rdparty/jvm/junit:junit",
        "//3rdparty/jvm/org/assertj:assertj_core",
        "//3rdparty/jvm/org/hamcrest:hamcrest_core",
        "//3rdparty/jvm/org/hamcrest:hamcrest_library",
        "//3rdparty/jvm/org/mockito:mockito_core",
        "//3rdparty/jvm/org/skyscreamer:jsonassert",
        "//3rdparty/jvm/org/springframework:spring_core",
        "//3rdparty/jvm/org/springframework:spring_test",
        "//external:jar/org/springframework/boot/spring_boot_starter_test",
        ":spring_boot_test",
        ":spring_boot_test_autoconfigure"
    ],
    visibility = [
        "//visibility:public"
    ]
)



java_library(
    name = "spring_boot_starter_tomcat",
    exports = [
        "//3rdparty/jvm/org/apache/tomcat/embed:tomcat_embed_core",
        "//3rdparty/jvm/org/apache/tomcat/embed:tomcat_embed_el",
        "//3rdparty/jvm/org/apache/tomcat/embed:tomcat_embed_websocket",
        "//external:jar/org/springframework/boot/spring_boot_starter_tomcat"
    ],
    visibility = [
        "//visibility:public"
    ]
)



java_library(
    name = "spring_boot_starter_web",
    exports = [
        "//3rdparty/jvm/com/fasterxml/jackson/core:jackson_databind",
        "//3rdparty/jvm/org/hibernate:hibernate_validator",
        "//3rdparty/jvm/org/springframework:spring_web",
        "//3rdparty/jvm/org/springframework:spring_webmvc",
        "//external:jar/org/springframework/boot/spring_boot_starter_web",
        ":spring_boot_starter",
        ":spring_boot_starter_tomcat"
    ],
    visibility = [
        "//visibility:public"
    ]
)



java_library(
    name = "spring_boot_test",
    exports = [
        "//external:jar/org/springframework/boot/spring_boot_test",
        ":spring_boot"
    ],
    visibility = [
        "//3rdparty/jvm:__subpackages__"
    ]
)



java_library(
    name = "spring_boot_test_autoconfigure",
    exports = [
        "//external:jar/org/springframework/boot/spring_boot_test_autoconfigure",
        ":spring_boot_autoconfigure",
        ":spring_boot_test"
    ],
    visibility = [
        "//3rdparty/jvm:__subpackages__"
    ]
)



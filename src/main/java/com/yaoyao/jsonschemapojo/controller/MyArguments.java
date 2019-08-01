package com.yaoyao.jsonschemapojo.controller;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.jsonschema2pojo.*;
import org.jsonschema2pojo.cli.ClassConverter;
import org.jsonschema2pojo.cli.UrlConverter;
import org.jsonschema2pojo.rules.RuleFactory;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.apache.commons.lang.StringUtils.defaultString;

/**
 * @Author: yaoyao
 * @Date: 2019/7/8 15:06
 * @Version: 1.0
 * @Description: TODO
 */
@Setter
public class MyArguments implements GenerationConfig {
    @Parameter(
            names = {"-h", "--help"},
            description = "Print help information and exit"
    )
    private boolean showHelp = false;
    @Parameter(
            names = {"-p", "--package"},
            description = "A java package used for generated types"
    )
    private String targetPackage;
    @Parameter(
            names = {"-t", "--target"},
            description = "The target directory into which generated types will be written",
            required = true
    )
    private File targetDirectory;
    @Parameter(
            names = {"-s", "--source"},
            description = "The source file(s) or directory(ies) from which JSON Schema will be read",
            required = true,
            converter = UrlConverter.class
    )
    private List<URL> sourcePaths;
    @Parameter(
            names = {"-b", "--generate-builders"},
            description = "Generate builder-style methods as well as setters"
    )
    private boolean generateBuilderMethods = false;
    @Parameter(
            names = {"--use-inner-class-builders"},
            description = "Generate an inner class with builder-style methods"
    )
    private boolean useInnerClassBuilders = false;
    @Parameter(
            names = {"-c", "--generate-constructors"},
            description = "Generate constructors"
    )
    private boolean generateConstructors = false;
    @Parameter(
            names = {"-r", "--constructors-required-only"},
            description = "Generate constructors with only required fields"
    )
    private boolean constructorsRequiredPropertiesOnly = false;
    @Parameter(
            names = {"-P", "--use-primitives"},
            description = "Use primitives instead of wrapper types for bean properties"
    )
    private boolean usePrimitives = false;
    @Parameter(
            names = {"-d", "--word-delimiters"},
            description = "The characters that should be considered as word delimiters when creating Java Bean property names from JSON property names"
    )
    private String propertyWordDelimiters = "- _";
    @Parameter(
            names = {"-l", "--long-integers"},
            description = "Use long (or Long) instead of int (or Integer) when the JSON Schema type 'integer' is encountered"
    )
    private boolean useLongIntegers = false;
    @Parameter(
            names = {"-bi", "--big-integers"},
            description = "Use BigInteger instead of int (or Integer) when the JSON Schema type 'integer' is encountered. Note that this overrides -l/--long-integers"
    )
    private boolean useBigIntegers = false;
    @Parameter(
            names = {"-f", "--float-numbers"},
            description = "Use float (or Float) instead of double (or Double) when the JSON Schema type 'number' is encountered"
    )
    private boolean useFloatNumbers = false;
    @Parameter(
            names = {"-i", "--big-decimals"},
            description = "Use BigDecimal instead of double (or Double) when the JSON Schema type 'number' is encountered. Note that this overrides -f/--float-numbers"
    )
    private boolean useBigDecimals = false;
    @Parameter(
            names = {"-E", "--omit-hashcode-and-equals"},
            description = "Omit hashCode and equals methods in the generated Java types"
    )
    private boolean omitHashcodeAndEquals = false;
    @Parameter(
            names = {"-S", "--omit-tostring"},
            description = "Omit the toString method in the generated Java types"
    )
    private boolean omitToString = false;
    @Parameter(
            names = {"-tse", "--tostring-excludes"},
            description = "The fields that should be excluded from generated toString methods"
    )
    private String toStringExcludes = "";
    @Parameter(
            names = {"-a", "--annotation-style"}
    )
    private AnnotationStyle annotationStyle;
    @Parameter(
            names = {"-ut", "--use-title-as-classname", "When set class names are generated from title attributes rather than property names."}
    )
    private boolean useTitleAsClassname;
    @Parameter(
            names = {"-il", "--inclusion-level"}
    )
    private InclusionLevel inclusionLevel;
    @Parameter(
            names = {"-A", "--custom-annotator"},
            description = "The fully qualified class name of referring to a custom annotator class that implements org.jsonschema2pojo.Annotator and will be used in addition to the --annotation-style. If you want to use a custom annotator alone, set --annotation-style to none",
            converter = ClassConverter.class
    )
    private Class<? extends Annotator> customAnnotator;
    @Parameter(
            names = {"-F", "--custom-rule-factory"},
            description = "The fully qualified class name of referring to a custom rule factory class that extends org.jsonschema2pojo.rules.RuleFactory to create custom rules for code generation.",
            converter = ClassConverter.class
    )
    private Class<? extends RuleFactory> customRuleFactory;
    @Parameter(
            names = {"-303", "--jsr303-annotations"},
            description = "Add JSR-303/349 annotations to generated Java types."
    )
    private boolean includeJsr303Annotations;
    @Parameter(
            names = {"-305", "--jsr305-annotations"},
            description = "Add JSR-305 annotations to generated Java types."
    )
    private boolean includeJsr305Annotations;
    @Parameter(
            names = {"-o", "--use-optional-for-getters"},
            description = "Use Optional for getters of non-required fields."
    )
    private boolean useOptionalForGetters;
    @Parameter(
            names = {"-T", "--source-type"}
    )
    private SourceType sourceType;
    @Parameter(
            names = {"-R", "--remove-old-output"},
            description = "Whether to empty the target directory before generation occurs, to clear out all source files that have been generated previously (indiscriminately deletes all files and folders)."
    )
    private boolean removeOldOutput;
    @Parameter(
            names = {"-e", "--output-encoding"},
            description = "The character encoding that should be used when writing the generated Java source files."
    )
    private String outputEncoding;
    @Parameter(
            names = {"-j", "--joda-dates"},
            description = "Whether to use org.joda.time.DateTime instead of java.util.Date when adding date-time type fields to generated Java types."
    )
    private boolean useJodaDates;
    @Parameter(
            names = {"-jd", "--joda-local-dates"},
            description = "Whether to use org.joda.time.LocalDate insteadof String when adding date type fields to generated Java types."
    )
    private boolean useJodaLocalDates;
    @Parameter(
            names = {"-jt", "--joda-local-times"},
            description = "Whether to use org.joda.time.LocalTime insteadof String when adding time type fields to generated Java types."
    )
    private boolean useJodaLocalTimes;
    @Parameter(
            names = {"-dtt", "--datetime-class"},
            description = "Specify datetime class"
    )
    private String dateTimeType;
    @Parameter(
            names = {"-tt", "--time-class"},
            description = "Specify time class"
    )
    private String timeType;
    @Parameter(
            names = {"-dt", "--date-class"},
            description = "Specify date class"
    )
    private String dateType;
    @Parameter(
            names = {"-c3", "--commons-lang3"},
            description = "Deprecated. Please remove it from your command-line arguments."
    )
    private boolean useCommonsLang3;
    @Parameter(
            names = {"-pl", "--parcelable"},
            description = "**EXPERIMENTAL** Whether to make the generated types 'parcelable' (for Android development)."
    )
    private boolean parcelable;
    @Parameter(
            names = {"-sl", "--serializable"},
            description = "Whether to make the generated types 'serializable'."
    )
    private boolean serializable;
    @Parameter(
            names = {"-N", "--null-collections"},
            description = "Initialize Set and List fields to null instead of an empty collection."
    )
    private boolean nullCollections;
    @Parameter(
            names = {"-y", "--class-prefix"},
            description = "Prefix for generated class."
    )
    private String classNamePrefix;
    @Parameter(
            names = {"-x", "--class-suffix"},
            description = "Suffix for generated class."
    )
    private String classNameSuffix;
    @Parameter(
            names = {"-fe", "--file-extensions"},
            description = "The extensions that should be considered as standard filename extensions when creating java class names."
    )
    private String fileExtensions;
    @Parameter(
            names = {"-D", "--enable-additional-properties"},
            description = "Enable additional properties support on generated types, regardless of the input schema(s)"
    )
    private boolean isIncludeAdditionalProperties;
    @Parameter(
            names = {"-dg", "--disable-getters"},
            description = "Whether to omit getter methods and create public fields instead."
    )
    private boolean disableGetters;
    @Parameter(
            names = {"-ds", "--disable-setters"},
            description = "Whether to omit setter methods and create public fields instead."
    )
    private boolean disableSetters;
    @Parameter(
            names = {"-tv", "--target-version"},
            description = "The target version for generated source files."
    )
    private String targetVersion;
    @Parameter(
            names = {"-ida", "--include-dynamic-accessors"},
            description = "Include dynamic getter, setter, and builder support on generated types."
    )
    private boolean includeDynamicAccessors;
    @Parameter(
            names = {"-idg", "--include-dynamic-getters"},
            description = "Include dynamic getter support on generated types."
    )
    private boolean includeDynamicGetters;
    @Parameter(
            names = {"-ids", "--include-dynamic-setters"},
            description = "Include dynamic setter support on generated types."
    )
    private boolean includeDynamicSetters;
    @Parameter(
            names = {"-idb", "--include-dynamic-builders"},
            description = "Include dynamic builder support on generated types."
    )
    private boolean includeDynamicBuilders;
    @Parameter(
            names = {"-fd", "--format-dates"},
            description = "Whether the fields of type `date` are formatted during serialization with a default pattern of `yyyy-MM-dd`"
    )
    private boolean formatDates;
    @Parameter(
            names = {"-ft", "--format-times"},
            description = "Whether the fields of type `time` are formatted during serialization with a default pattern of `HH:mm:ss.SSS`"
    )
    private boolean formatTimes;
    @Parameter(
            names = {"-fdt", "--format-date-times"},
            description = "Whether the fields of type `date-time` are formatted during serialization with a default pattern of `yyyy-MM-dd'T'HH:mm:ss.SSSZ` and timezone set to default value of `UTC`"
    )
    private boolean formatDateTimes;
    @Parameter(
            names = {"-dp", "--date-pattern"},
            description = "A custom pattern to use when formatting date fields during serialization"
    )
    private String customDatePattern;
    @Parameter(
            names = {"-tp", "--time-pattern"},
            description = "A custom pattern to use when formatting time fields during serialization"
    )
    private String customTimePattern;
    @Parameter(
            names = {"-dtp", "--date-time-pattern"},
            description = "A custom pattern to use when formatting date-time fields during serialization"
    )
    private String customDateTimePattern;
    @Parameter(
            names = {"-rpd", "--ref-fragment-path-delimiters"},
            description = "A string containing any characters that should act as path delimiters when resolving $ref fragments. By default, #, / and . are used in an attempt to support JSON Pointer and JSON Path."
    )
    private String refFragmentPathDelimiters;
    @Parameter(
            names = {"-sso", "--source-sort-order"},
            description = "The sort order to be applied to the source files.  Available options are: OS, FILES_FIRST or SUBDIRS_FIRST"
    )
    private SourceSortOrder sourceSortOrder;
    @Parameter(
            names = {"-tl", "--target-language"},
            description = "The type of code that will be generated.  Available options are: JAVA or SCALA"
    )
    private Language targetLanguage;
    @Parameter(
            names = {"-ftm", "--format-type-mapping"},
            description = "Mapping from format identifier to type: <format>:<fully.qualified.Type>.",
            variableArity = true
    )
    private List<String> formatTypeMapping;
    private static final int EXIT_OKAY = 0;
    private static final int EXIT_ERROR = 1;

    public MyArguments() {
        this.annotationStyle = AnnotationStyle.JACKSON;
        this.useTitleAsClassname = false;
        this.inclusionLevel = InclusionLevel.NON_NULL;
        this.customAnnotator = NoopAnnotator.class;
        this.customRuleFactory = RuleFactory.class;
        this.includeJsr303Annotations = false;
        this.includeJsr305Annotations = false;
        this.useOptionalForGetters = false;
        this.sourceType = SourceType.JSONSCHEMA;
        this.removeOldOutput = false;
        this.outputEncoding = "UTF-8";
        this.useJodaDates = false;
        this.useJodaLocalDates = false;
        this.useJodaLocalTimes = false;
        this.useCommonsLang3 = false;
        this.parcelable = false;
        this.serializable = false;
        this.nullCollections = false;
        this.classNamePrefix = "";
        this.classNameSuffix = "";
        this.fileExtensions = "";
        this.isIncludeAdditionalProperties = false;
        this.disableGetters = false;
        this.disableSetters = false;
        this.targetVersion = "1.6";
        this.includeDynamicAccessors = false;
        this.includeDynamicGetters = false;
        this.includeDynamicSetters = false;
        this.includeDynamicBuilders = false;
        this.formatDates = false;
        this.formatTimes = false;
        this.formatDateTimes = false;
        this.refFragmentPathDelimiters = "#/.";
        this.sourceSortOrder = SourceSortOrder.OS;
        this.targetLanguage = Language.JAVA;
        this.formatTypeMapping = new ArrayList();
    }

    public MyArguments parse(String[] args) {
        JCommander jCommander = new JCommander(this);
        jCommander.setProgramName("jsonschema2pojo");

        try {
            jCommander.parse(args);
            if (this.showHelp) {
                jCommander.usage();
                this.exit(0);
            }
        } catch (ParameterException var4) {
            System.err.println(var4.getMessage());
            jCommander.usage();
            this.exit(1);
        }

        return this;
    }
    @Override
    public Iterator<URL> getSource() {
        return this.sourcePaths.iterator();
    }

    @Override
    public File getTargetDirectory() {
        return this.targetDirectory;
    }

    @Override
    public String getTargetPackage() {
        return this.targetPackage;
    }

    @Override
    public boolean isGenerateBuilders() {
        return this.generateBuilderMethods;
    }

    @Override
    public boolean isUseInnerClassBuilders() {
        return this.useInnerClassBuilders;
    }

    @Override
    public boolean isUsePrimitives() {
        return this.usePrimitives;
    }

    @Override
    public char[] getPropertyWordDelimiters() {
        return StringUtils.defaultString(this.propertyWordDelimiters).toCharArray();
    }

    @Override
    public boolean isUseLongIntegers() {
        return this.useLongIntegers;
    }

    @Override
    public boolean isUseDoubleNumbers() {
        return !this.useFloatNumbers;
    }

    @Override
    public boolean isIncludeHashcodeAndEquals() {
        return !this.omitHashcodeAndEquals;
    }

    @Override
    public boolean isIncludeToString() {
        return !this.omitToString;
    }

    @Override
    public String[] getToStringExcludes() {
        return StringUtils.defaultString(this.toStringExcludes).split(" ");
    }

    @Override
    public AnnotationStyle getAnnotationStyle() {
        return this.annotationStyle;
    }

    @Override
    public boolean isUseTitleAsClassname() {
        return this.useTitleAsClassname;
    }

    @Override
    public InclusionLevel getInclusionLevel() {
        return this.inclusionLevel;
    }

    @Override
    public Class<? extends Annotator> getCustomAnnotator() {
        return this.customAnnotator;
    }

    @Override
    public Class<? extends RuleFactory> getCustomRuleFactory() {
        return this.customRuleFactory;
    }

    @Override
    public boolean isIncludeJsr303Annotations() {
        return this.includeJsr303Annotations;
    }

    @Override
    public boolean isIncludeJsr305Annotations() {
        return this.includeJsr305Annotations;
    }

    @Override
    public boolean isUseOptionalForGetters() {
        return this.useOptionalForGetters;
    }

    @Override
    public SourceType getSourceType() {
        return this.sourceType;
    }

    @Override
    public boolean isRemoveOldOutput() {
        return this.removeOldOutput;
    }

    @Override
    public String getOutputEncoding() {
        return this.outputEncoding;
    }

    @Override
    public boolean isUseJodaDates() {
        return this.useJodaDates;
    }

    @Override
    public boolean isUseJodaLocalDates() {
        return this.useJodaLocalDates;
    }

    @Override
    public boolean isUseJodaLocalTimes() {
        return this.useJodaLocalTimes;
    }

    public boolean isUseCommonsLang3() {
        return this.useCommonsLang3;
    }

    @Override
    public boolean isParcelable() {
        return this.parcelable;
    }

    @Override
    public boolean isSerializable() {
        return this.serializable;
    }

    protected void exit(int status) {
        System.exit(status);
    }

    @Override
    public FileFilter getFileFilter() {
        return new AllFileFilter();
    }

    @Override
    public boolean isInitializeCollections() {
        return !this.nullCollections;
    }

    @Override
    public String getClassNamePrefix() {
        return this.classNamePrefix;
    }

    @Override
    public String getClassNameSuffix() {
        return this.classNameSuffix;
    }

    @Override
    public String[] getFileExtensions() {
        return StringUtils.defaultString(this.fileExtensions).split(" ");
    }

    @Override
    public boolean isIncludeConstructors() {
        return this.generateConstructors;
    }

    @Override
    public boolean isConstructorsRequiredPropertiesOnly() {
        return this.constructorsRequiredPropertiesOnly;
    }

    @Override
    public boolean isIncludeAdditionalProperties() {
        return this.isIncludeAdditionalProperties;
    }

    @Override
    public boolean isIncludeGetters() {
        return !this.disableGetters;
    }

    @Override
    public boolean isIncludeSetters() {
        return !this.disableSetters;
    }

    @Override
    public String getTargetVersion() {
        return this.targetVersion;
    }

    @Override
    public boolean isIncludeDynamicAccessors() {
        return this.includeDynamicAccessors;
    }

    @Override
    public boolean isIncludeDynamicGetters() {
        return this.includeDynamicGetters;
    }

    @Override
    public boolean isIncludeDynamicSetters() {
        return this.includeDynamicSetters;
    }

    @Override
    public boolean isIncludeDynamicBuilders() {
        return this.includeDynamicBuilders;
    }

    @Override
    public String getDateTimeType() {
        return this.dateTimeType;
    }

    @Override
    public String getDateType() {
        return this.dateType;
    }

    @Override
    public String getTimeType() {
        return this.timeType;
    }

    @Override
    public boolean isUseBigIntegers() {
        return this.useBigIntegers;
    }

    @Override
    public boolean isUseBigDecimals() {
        return this.useBigDecimals;
    }

    @Override
    public boolean isFormatDateTimes() {
        return this.formatDateTimes;
    }

    @Override
    public boolean isFormatDates() {
        return this.formatDates;
    }

    @Override
    public boolean isFormatTimes() {
        return this.formatTimes;
    }

    @Override
    public String getRefFragmentPathDelimiters() {
        return this.refFragmentPathDelimiters;
    }

    @Override
    public String getCustomDatePattern() {
        return this.customDatePattern;
    }

    @Override
    public String getCustomTimePattern() {
        return this.customTimePattern;
    }

    @Override
    public String getCustomDateTimePattern() {
        return this.customDateTimePattern;
    }

    @Override
    public SourceSortOrder getSourceSortOrder() {
        return this.sourceSortOrder;
    }

    @Override
    public Language getTargetLanguage() {
        return this.targetLanguage;
    }

    @Override
    public Map<String, String> getFormatTypeMapping() {
        return (Map)this.formatTypeMapping.stream().collect(Collectors.toMap((m) -> {
            return m.split(":")[0];
        }, (m) -> {
            return m.split(":")[1];
        }));
    }
}

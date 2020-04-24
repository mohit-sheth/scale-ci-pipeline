#!/usr/bin/env groovy
/*
def build(){
	load "pipeline_scripta/build.groovy"
}


def install(){
        load "pipeline_scripta/build.groovy"
}


def uperf(){
        load "pipeline_scripta/uperf.groovy"
}


def http(def templates){
	def http_templates = templates
	load "pipeline-scripts/http.groovy"
}


def scaleup(def worker_count){
	def scaleup_worker_count = worker_count
	load "pipeline-scripts/openshiftv4_scale.groovy"
}


def pipeline_id = env.BUILD_ID
def property_file_name = "aws.properties"
println "Current pipeline job build id is '${pipeline_id}'"
sh "wget ${AWS_PROPERTIES_FILE} -O ${property_file_name}"
sh "cat ${property_file_name}"
def aws_properties = readProperties file: property_file_name
def orchestration_host = aws_properties[ORCHESTRATION_HOST]
def http_test_app_templates_small = aws_properties['HTTP_TEST_APP_TEMPLATES_SMALL']
def http_test_app_templates_large = aws_properties['HTTP_TEST_APP_TEMPLATES_LARGE']
def scaleup_first_run = aws_properties['SCALEUP_FIRST_RUN']
def scaleup_second_run = aws_properties['SCALEUP_SECOND_RUN']
def scaleup_third_run = aws_properties['SCALEUP_THIRD_RUN']

build()
install()
http(http_test_app_templates_small)
uperf()
scaleup(scaleup_first_run)
http(http_test_app_templates_large)
scaleup(scaleup_second_run)
*/

def http(String myvar){
	def myVar = myvar
	def tools = new GroovyScriptEngine( '.' ).with {
	loadScriptByName( 'pipeline-scripts/http.groovy' )
	}
	this.metaClass.mixin tools
	function(myVar)
}

http("3")
http("5")

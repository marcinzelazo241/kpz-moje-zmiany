FROM jenkins/jenkins:2.554-jdk21

USER root

RUN jenkins-plugin-cli --plugins \
    configuration-as-code \
    workflow-aggregator \
    git \
    job-dsl \
    jacoco \
    pipeline-stage-view
	
RUN apt-get update && apt-get install -y maven

USER jenkins
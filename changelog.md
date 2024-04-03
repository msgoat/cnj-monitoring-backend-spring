# Changelog

All notable changes to `cnj-monitoring-backend-spring` will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

## [8.0.0] - 2024-04-03
### Changed
- upgraded Spring Boot to version 3.2.4
- upgraded Java to version 21
- upgraded Maven plugins and dependencies
- consolidated POM with other showcases
- consolidated system tests with other showcases
- commit-stage builds produce Docker images for linux/amd64 and linux/arm64/v8 platforms now
- Docker images use Generational Z garbage collector by default
- consolidated common dependencies
- upgraded common cloudtrain dependencies

## [7.1.0] - 2023-11-14
### Added
- Tagging of git branch
### Changed
- Upgraded to helm-maven-plugin version 5.0.0
- Now a helm chart is packaged and pushed as an artifact during the commit-stage build
- Now the helm chart is pulled before deploying during the integration-test-stage build

## [7.0.0] - 2023-06-09
### Changed
- moved to new AWS CodeBuild build pipeline
- moved to new CloudTrain EKS cluster
- upgraded everything
- added docker-compose.yml to run the showcase locally

## [6.0.0] - 2023-02-23
### Changed
- upgraded to Java 17
- upgraded to Spring Boot 3.0.2
- consolidated with hello world use case
- upgraded all cnj-common-* dependencies
- moved to new build pipeline on AWS

## [5.4.0] - 2022-08-12
### Changed
- consolidated application-specific prometheus metric names with other showcases
- upgraded to cnj-common-observability-spring 0.4.0 to have consolidated Undertow metric names
- name of Spring Boot application JAR is using suffix `-spring` now

## [5.3.0] - 2022-06-30
### Added
### Changed
- changed probe endpoints in Helm chart from general health endpoints to specific health endpoints to improve observability on Kubernetes

## [5.2.0] - 2022-06-28
### Added
- added support for Micrometer annotations with MetricsConfiguration
- added @Counted and @Timed annotations to methods of boundary TaskManagement representing business operations
- added HOW-TO section for Prometheus metrics exposure to README.md
### Changed
- upgraded to Spring Boot 2.7.1
- upgraded to Micrometer 1.9.1

## [5.1.0] - 2022-03-09
### Added
### Changed
- re-release after repo split

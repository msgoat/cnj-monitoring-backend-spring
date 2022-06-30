# Changelog

All notable changes to `cnj-monitoring-backend-spring` will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]


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

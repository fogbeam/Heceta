#!/bin/sh

grails clean; grails -Dserver.port=8300 -Dheceta.home=/opt/fogcutter/heceta run-app


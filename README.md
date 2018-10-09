# airbnb

mysql database credentials:
 * Username: userLQE 
 * Password: 2dAlhk2RqPhVlFOK 

how to connect to server with database:
 * download openshift origin client tools from https://github.com/openshift/origin/releases
 * unzip oc executive
 * open cmd/terminal in oc folder
 * run commands:
 1. oc login https://api.starter-us-west-1.openshift.com --token=bERk1VH9HU901CKQtPUQirsdaknTAWaGSib8Vm2KcmI
 2. oc port-forward airbnb-1-9zt82 3306:3306
 * don't close command prompt unless you finished your work with db

def newGit(repo)
{
  git "${repo}"
}
def newMaven()
{
   sh 'mvn package'
}
def newDeploy(ip,appname)
{
  sh "scp /var/lib/jenkins/workspace/pipelinelib/webapp/target/webapp.war cloud_user@${ip}:/var/lib/tomcat9/webapps/${appname}.war"
}
def runSelenium(path)
{
  sh "java -jar ${path}/testing.jar"
}
def newApprovals(name)
{
  input message: 'Wait for Approval', submitter: "${name}"
}

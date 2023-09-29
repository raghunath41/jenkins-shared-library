def call(String git_branch = 'main', String git_credentials = null, String git_url = null)
{
    checkout([$class: 'GitSCM',
                branches: [[name: "*/${git_branch}"]], 
                userRemoteConfigs: [[credentialsId: "${git_credentials}", url: "${git_url}"]]
                ])
}
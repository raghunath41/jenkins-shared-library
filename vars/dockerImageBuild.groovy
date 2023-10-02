def call(String dockerfile = "Dockerfile",
         String image_name = null,
         String image_tag = null,
         String registryURL = null,
         String registryCredentials = null) {
          def imageBuild = docker.build("${image_name}:${image_tag}")

               docker.withRegistry("${registryURL}", "${registryCredentials}")
               {
                imageBuild.push()
               }

               sh ''' docker images
                      docker image prune -f
                      docker builder prune -f
                      docker rmi ${image_name}:${image_tag}
                      docker images '''

         }
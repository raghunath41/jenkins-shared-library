def call(String dockerfile = "Dockerfile",
         String image_name = null,
         String image_tag = null,
         String registryURL = null,
         String registryCredentials = null) {
          def imageBuild = docker.build("${image_name}:${image_tag}", " -f ${dockerfile}" .)

               docker.withRegistry("${registryURL}", "${registryCredentials}")
               {
                imageBuild.push()
               }

               sh 'docker images'

         }
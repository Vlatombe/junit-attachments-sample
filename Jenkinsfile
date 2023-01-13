node {
    checkout scm
    splits = splitTests parallelism: count(2)
}

def branches = [:]
for (int i = 0; i < splits.size(); i++) {
    def num = i
    def split = splits[num]
    branches['split-' + num] = {
        node {
            checkout scm
            try {
                writeFile file: "excludes.txt", text: split.join('\n')
                sh 'mvn -B -ntp clean install -Dsurefire.excludesFile=$(pwd)/excludes.txt'
            } finally {
                step([$class            : 'JUnitResultArchiver'
                      ,testResults       : '**/target/surefire-reports/TEST-*.xml'
                      ,testDataPublishers: [[$class: 'AttachmentPublisher']]
                ])
            }
        }
    }
}
parallel branches

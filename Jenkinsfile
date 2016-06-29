node {
    checkout scm
    try {
        sh "mvn clean install"
    } finally {
        step([$class            : 'JUnitResultArchiver'
              ,testResults       : '**/target/surefire-reports/TEST-*.xml'
              ,testDataPublishers: [[$class: 'AttachmentPublisher']]
        ])
    }
}
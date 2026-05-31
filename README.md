# Github Repos

REST API made in Spring Boot 4 and Java 25 for listing all repositories of a specified user that aren't forks

---

## Running

Starting the API

```bash
./gradlew bootRun
```

Running tests

```bash
./gradlew test
```

---

## Usage

```bash
http://localhost:8080/{username}
```

For example

```bash
http://localhost:8080/octocat
```

Gives

```json
[
  {
    "repoName": "git-consortium",
    "ownerLogin": "octocat",
    "branches": [
      {
        "branchName": "master",
        "lastCommitSha": "b33a9c7c02ad93f621fa38f0e9fc9e867e12fa0e"
      }
    ]
  },
  {
    "repoName": "hello-worId",
    "ownerLogin": "octocat",
    "branches": [
      {
        "branchName": "master",
        "lastCommitSha": "7e068727fdb347b685b658d2981f8c85f7bf0585"
      }
    ]
  },
  {
    "repoName": "Hello-World",
    "ownerLogin": "octocat",
    "branches": [
      {
        "branchName": "master",
        "lastCommitSha": "7fd1a60b01f91b314f59955a4e4d4e80d8edf11d"
      },
      {
        "branchName": "octocat-patch-1",
        "lastCommitSha": "b1b3f9723831141a31a1a7252a213e216ea76e56"
      },
      {
        "branchName": "test",
        "lastCommitSha": "b3cbd5bbd7e81436d2eee04537ea2b4c0cad4cdf"
      }
    ]
  },
  {
    "repoName": "octocat.github.io",
    "ownerLogin": "octocat",
    "branches": [
      {
        "branchName": "gh-pages",
        "lastCommitSha": "c0e4a095428f36b81f0bd4239d353f71918cbef3"
      },
      {
        "branchName": "master",
        "lastCommitSha": "3a9796cf19902af0f7e677391b340f1ae4128433"
      }
    ]
  },
  {
    "repoName": "Spoon-Knife",
    "ownerLogin": "octocat",
    "branches": [
      {
        "branchName": "change-the-title",
        "lastCommitSha": "f439fc5710cd87a4025247e8f75901cdadf5333d"
      },
      {
        "branchName": "main",
        "lastCommitSha": "d0dd1f61b33d64e29d8bc1372a94ef6a2fee76a9"
      },
      {
        "branchName": "test-branch",
        "lastCommitSha": "58060701b538587e8b4ab127253e6ed6fbdc53d1"
      }
    ]
  },
  {
    "repoName": "test-repo1",
    "ownerLogin": "octocat",
    "branches": [
      {
        "branchName": "gh-pages",
        "lastCommitSha": "57523742631876181d95bc268e09fb3fd1a4d85e"
      }
    ]
  }
]
```

# jungol
Reference to "http://jungol.co.kr/"

# Git Proxy Setting
$ vi ~/.gitconfig
[user]
	name = rolroralra
	email = shyoung.kim@samsung.com
	[http]
		proxy = http://70.10.15.10:8080
		sslVerify = false
	[https]
		proxy = http://70.10.15.10:8080
[credential]
	helper = wincred
[filter "lfs"]
	clean = git-lfs clean -- %f
	smudge = git-lfs smudge -- %f
	process = git-lfs filter-process
	required = true
[core]
	autocrlf = true

- Explain what is swap , what is the algorithms used in swap ? 
- what is the reason for swapping ? 
- what is the minimum amount memory being swapped all the time ? 
- what defines the block size ? 
- what is swap address means ?
- commands to identify the swap problems ? 
- is it swap percentage is configurable ? 
- Virtual file system ?  
- what happens if a process is requesting more memory than allocated ? 
- what is ulimit ? 
- is it finite number of threads available in an Operating system ? 
- how to debug a process using more memory ? 
- how to rescue a process which is using more memory ? 
- what is a zombie process ? 
- what is proc ? 
- is it possible for the application to limit its memory usage ? 
- what is cgroup ?
- how cgroup is configured ?

-------------------------------
 - what happens when you type google.com
 - what happens when you type ls *al
 - what happens when you type ssh somehost
 - explain the OSI layer
 
 ------------------
 linux internals read : https://landley.net/writing/memory-faq.txt
 
 - What is resident memory in top command ? 
 - What is swap in memory management ? 
 - What is load average in linux ? 
 - What are the states in linux for a process ? 
 - What does vmstat command give as output ? 
 - What is the content of inode ? 
 	- File name
	- File permission
	- File size and links 
- Find out how much memory the machine is using ? 
	- Free - m
 - What is the preferred swap size in linux ?
	- Twice the amount of physical memory - if not the same size of memory installed 
- What is the difference between hardlink and softlink ? 
- Change permissions of a file using commands ?
	- Chmod, chown , chgrp
- What are the different file system names in linux ? 
	- ext3/ext4, XFS, BtrFs
- Write a command that will look for files with an extension "c", and has the occurrence of the string "apple" in it.
	-> Find ./ -name “*.c” | xargs grep -i “apple”
- what is nscd?
	-  Nscd is a daemon that provides a cache for the most common name service requests. The default configuration file, /etc/nscd. conf, determines the behavior of the cache daemon.
 - explain more about virtual file system ?
  	- virtual file system on top of all the type of filesystems available in linux operating system . so that the user have a single user interface to access them and use it in the same manner. its an abstract layer on top of the concrete file system. https://en.wikipedia.org/wiki/Virtual_file_system
 
 
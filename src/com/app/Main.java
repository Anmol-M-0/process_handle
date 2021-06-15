package com.app;

import java.util.Optional;

public class Main {
	public static void main(String[] args) {
		
		ProcessHandle.allProcesses()
			.peek(i->{
				System.out.print("peek");
				System.out.println(i.info());
				System.out.println(i.pid());
			})
			.map(p->p.info())
			.filter(i->i.user().filter(s->!s.equals(Optional.empty())).isPresent())
//			.filter(info->info.command().filter(s->s.contains("java")).isPresent())
//			.map(info->info.arguments())
//			.flatMap(str->Arrays.stream(str))
			.flatMap(i->i.command().stream())
			.filter(str->str.contains("chr"))
			.forEach(System.out::println);
		
		
		
	}

}

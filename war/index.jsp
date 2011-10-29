<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<title>Trigram Generator</title>
		<link rel="stylesheet" href="css/style.css" />
	</head>
	<body>
		<div class="wrapper">
			<div class="title">Trigram Generator</div>
			<div class="content heading">What does the Trigram Generator do?</div>
			<div class="content">
				What it does is look at pairs of words
				and find out what word usually shows up after that pair of words.
				For instance, in the sentence "I like coding", the trigram generator will see that
				"I like" is followed by "coding". It counts up all of the probabilities in the
				original text and uses them to generate random sentences. These sentences
				will be similar to those found in the original text, but "mashed up"
				because the generator is looking at pairs of words to select the next
				word rather than looking at entire sentence.
			</div>
			<div class="content heading">How do I use this program?</div>
			<div class="content">
				Paste or type some text into the box and then click
				"Generate" and it will create words in the bottom.
			</div>
			<div class="content">
				<form action="trigramgenerator" method="post">
					<textarea rows="10" cols="50" name="inputText">${input}</textarea>
					<input type="submit" value="Generate" class="submit"/>
				</form>
			</div>
			<div class="separator"></div>
			<c:if test="${not empty output}">
				<div class="content heading">Output</div>
			    <div class="content output">${output}</div>
			    <div class="content">Try clicking the generate button again to generate a different output.</div>
			    <div class="separator"></div>
			</c:if>
			<div class="content">Code : <a href="https://github.com/AnandGurumurthi/TrigramGenerator" target="_new">https://github.com/AnandGurumurthi/TrigramGenerator</a></div>
			<div class="content">Idea from <a href="http://codekata.pragprog.com/2007/01/kata_fourteen_t.html" target="_new">CodeKata</a></div>
		</div>
	</body>
</html>

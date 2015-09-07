var gulp = require('gulp');

var concatCSS = require('gulp-concat-css'),
    minifyCSS = require('gulp-minify-css'),
	rename = require('gulp-rename'),
    notify = require("gulp-notify");

gulp.task('default', function () {
	return gulp.src('../css/*.css')
		.pipe(notify("Gulp start!"))
		.pipe(concatCSS("bundle.css"))
		.pipe(minifyCSS())
		.pipe(concatCSS("bundle.css"))
		.pipe(rename("bundle.min.css"))
		.pipe(gulp.dest('../css/'))
		.pipe(notify("Done!"));
});

gulp.task('watch', function (){
	gulp.watch('../css/*.css',['default']);
});
Dir.glob('**/compose_compiler_metrics').each do |report_dir|
  next if report_dir.include?("vendor/bundle")

  compose_compiler_metrics.report_difference(report_dir, "#{report_dir}_baseline")
end
